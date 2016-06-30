/*     */ package game;
/*     */ 
/*     */ import java.util.Random;
/*     */ import org.lwjgl.input.Keyboard;
/*     */ import org.newdawn.slick.GameContainer;
/*     */ import org.newdawn.slick.Graphics;
/*     */ import org.newdawn.slick.SlickException;
/*     */ import org.newdawn.slick.Sound;
/*     */ import org.newdawn.slick.geom.Rectangle;
/*     */ import org.newdawn.slick.geom.Vector2f;
/*     */ import org.newdawn.slick.state.BasicGameState;
/*     */ import org.newdawn.slick.state.StateBasedGame;
/*     */ import org.newdawn.slick.tiled.TiledMap;
/*     */ 
/*     */ public class LevelOne extends BasicGameState
/*     */ {
/*     */   private TiledMap map;
/*     */   public boolean collision;
/*  19 */   private boolean death = false;
/*  20 */   public int playerY = 537;
/*     */   
/*     */   private int mapX;
/*     */   private int mapY;
/*     */   private Rectangle boundingbox;
/*     */   private Dart[] darts;
/*     */   private Enemies[] enemy;
/*  27 */   private int rateTime = 0;
/*  28 */   private int time = 0;
/*  29 */   private int rateEnemy = 0;
/*  30 */   private int currentDart = 0;
/*  31 */   private int currentEnemy = 0;
/*  32 */   private static int RATE = 150;
/*  33 */   private static int ENEMY_RATE = 1250;
/*     */   
/*     */   private int randomHeight;
/*     */   
/*     */   private Sound teemoAttack;
/*     */   
/*  39 */   Player player = new Player();
/*  40 */   Enemies e = new Enemies();
/*  41 */   Dart d = new Dart();
/*     */   
/*     */   public LevelOne(int State) {}
/*     */   
/*     */   public void init(GameContainer container, StateBasedGame sbg)
/*     */     throws SlickException
/*     */   {
/*  48 */     this.map = new TiledMap("res/map.tmx");
/*  49 */     this.boundingbox = new Rectangle(0.0F, 0.0F, 5.0F, 642.0F);
/*     */     
/*  51 */     this.enemy = new Enemies[5];
/*  52 */     for (int i = 0; i < this.enemy.length; i++) {
/*  53 */       this.enemy[i] = new Enemies();
/*     */     }
/*     */     
/*  56 */     this.darts = new Dart[10];
/*  57 */     this.teemoAttack = new Sound("res/teemoAttack.wav");
/*     */     
/*  59 */     for (int i = 0; i < this.darts.length; i++) {
/*  60 */       this.darts[i] = new Dart();
/*     */     }
/*  62 */     this.e.init(container, sbg);
/*  63 */     this.player.init(container, sbg);
/*     */   }
/*     */   
/*     */   public void update(GameContainer container, StateBasedGame sbg, int delta)
/*     */     throws SlickException
/*     */   {
/*  69 */     checkDeath(this.enemy);
/*  70 */     randomHeight(this.enemy);
/*     */     
/*  72 */     this.e.update(container, sbg, delta);
/*  73 */     this.player.update(container, sbg, delta);
/*  74 */     if (this.death) {
/*  75 */       sbg.enterState(2);
/*     */     }
/*  77 */     checkCollision(this.darts);
/*     */     
/*  79 */     if (this.player.x < 0.0D) {
/*  80 */       this.mapX += 1;
/*  81 */       this.player.x = 32.0D;
/*     */     }
/*  83 */     if ((this.player.x > 32.0D) && (this.mapX > 0)) {
/*  84 */       this.mapX -= 1;
/*  85 */       this.player.x = 0.0D;
/*     */     }
/*  87 */     if (this.mapX == 0) {
/*  88 */       this.player.x = 0.0D;
/*     */     }
/*  90 */     if (this.mapX == 142) {
/*  91 */       this.player.x = 36.0D;
/*     */     }
/*     */     
/*     */ 
/*  95 */     this.time += delta;
/*     */     
/*  97 */     this.rateTime += delta;
/*  98 */     if ((this.rateTime > RATE) && (Keyboard.isKeyDown(57)))
/*     */     {
/* 100 */       this.darts[this.currentDart] = new Dart(new Vector2f(255.0F, this.player.playerY + 70), new Vector2f(1000.0F, 50.0F));
/*     */       
/* 102 */       this.currentDart += 1;
/*     */       
/* 104 */       this.teemoAttack.play();
/*     */       
/* 106 */       if (this.currentDart >= this.darts.length) {
/* 107 */         this.currentDart = 0;
/*     */       }
/* 109 */       this.rateTime = 0;
/*     */     }
/*     */     
/*     */ 
/* 113 */     this.rateEnemy += delta;
/* 114 */     if (this.rateEnemy > ENEMY_RATE) {
/* 115 */       this.enemy[this.currentEnemy] = new Enemies(new Vector2f(1000.0F, 550 - this.randomHeight), new Vector2f(-1000.0F, 0.0F));
/* 116 */       this.currentEnemy += 1;
/* 117 */       if (this.currentEnemy >= this.enemy.length) {
/* 118 */         this.currentEnemy = 0;
/*     */       }
/* 120 */       this.rateEnemy = 0;
/*     */     }
/*     */     Object localObject;
/* 123 */     int j = (localObject = this.darts).length; for (int i = 0; i < j; i++) { Dart d = localObject[i];
/* 124 */       d.update(container, sbg, delta);
/*     */     }
/* 126 */     j = (localObject = this.enemy).length; for (i = 0; i < j; i++) { Enemies ee = localObject[i];
/* 127 */       ee.update(container, sbg, delta);
/*     */     }
/*     */   }
/*     */   
/*     */   public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException
/*     */   {
/* 133 */     this.map.render((int)this.player.x - 32, (int)this.player.y, this.mapX, this.mapY, this.mapX + 33, this.mapY + 24);
/* 134 */     this.player.render(container, sbg, g);
/*     */     
/* 136 */     g.setColor(org.newdawn.slick.Color.decode("#FF6633"));
/* 137 */     g.fill(this.boundingbox);
/* 138 */     g.draw(this.boundingbox);
/* 139 */     g.drawString("Time Survived:" + this.time / 1000, 850.0F, 25.0F);
/*     */     
/* 141 */     this.e.render(container, sbg, g);
/* 142 */     Object localObject; int j = (localObject = this.enemy).length; for (int i = 0; i < j; i++) { Enemies ee = localObject[i];
/* 143 */       ee.render(container, sbg, g);
/*     */     }
/*     */     
/* 146 */     j = (localObject = this.darts).length; for (i = 0; i < j; i++) { Dart d = localObject[i];
/* 147 */       d.render(container, sbg, g);
/*     */     }
/*     */   }
/*     */   
/*     */   public void checkCollision(Dart[] dart)
/*     */   {
/*     */     Dart[] arrayOfDart;
/* 154 */     int j = (arrayOfDart = dart).length; for (int i = 0; i < j; i++) { Dart d = arrayOfDart[i];
/* 155 */       Enemies[] arrayOfEnemies; int m = (arrayOfEnemies = this.enemy).length; for (int k = 0; k < m; k++) { Enemies ee = arrayOfEnemies[k];
/* 156 */         if ((d.islive()) && (ee.enemyisAlive()) && 
/* 157 */           (d.boundingbox.intersects(ee.boundingbox))) {
/* 158 */           d.setAlive(false);
/* 159 */           ee.count += 1;
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void checkDeath(Enemies[] enemy) { Enemies[] arrayOfEnemies;
/* 166 */     int j = (arrayOfEnemies = enemy).length; for (int i = 0; i < j; i++) { Enemies ee = arrayOfEnemies[i];
/* 167 */       if ((this.player.boundingbox != null) && (ee.boundingbox != null) && (ee.boundingbox.intersects(this.player.boundingbox))) {
/* 168 */         this.death = true;
/*     */       }
/* 170 */       if ((ee.boundingbox != null) && (ee.boundingbox.intersects(this.boundingbox)))
/* 171 */         this.death = true;
/*     */     }
/*     */   }
/*     */   
/*     */   public void randomHeight(Enemies[] enemy) { Enemies[] arrayOfEnemies;
/* 176 */     int j = (arrayOfEnemies = enemy).length; for (int i = 0; i < j; i++) { Enemies ee = arrayOfEnemies[i];
/* 177 */       Random rand = new Random();
/* 178 */       this.randomHeight = (rand.nextInt(450) + 0);
/*     */     }
/*     */   }
/*     */   
/*     */   public int getID() {
/* 183 */     return 1;
/*     */   }
/*     */ }