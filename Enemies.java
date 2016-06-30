/*    */ package game;
/*    */ 
/*    */ import org.newdawn.slick.Color;
/*    */ import org.newdawn.slick.GameContainer;
/*    */ import org.newdawn.slick.Graphics;
/*    */ import org.newdawn.slick.Image;
/*    */ import org.newdawn.slick.SlickException;
/*    */ import org.newdawn.slick.geom.Rectangle;
/*    */ import org.newdawn.slick.geom.Vector2f;
/*    */ import org.newdawn.slick.state.StateBasedGame;
/*    */ 
/*    */ public class Enemies
/*    */ {
/*    */   private Image enemy;
/*    */   Rectangle boundingbox;
/* 16 */   private boolean alive = true;
/*    */   Vector2f position;
/*    */   private Vector2f speed;
/* 19 */   private static int LIFETIME = 2000;
/* 20 */   private int lived = 0;
/*    */   
/*    */   public boolean collision;
/*    */   public boolean youLose;
/*    */   public int count;
/*    */   public boolean destroy;
/*    */   public int move;
/*    */   public int score;
/*    */   public int enemiesSlain;
/*    */   
/*    */   public Enemies(Vector2f position, Vector2f spd)
/*    */   {
/* 32 */     this.position = position;
/* 33 */     this.speed = spd;
/*    */   }
/*    */   
/* 36 */   public Enemies() { setEnemyAlive(false); }
/*    */   
/*    */   public void init(GameContainer container, StateBasedGame sbg) throws SlickException
/*    */   {
/* 40 */     if (enemyisAlive()) {
/* 41 */       this.enemy = new Image("res/enemy.png");
/* 42 */       this.boundingbox = new Rectangle(this.position.getX() - 10.0F, this.position.getY() + 7.0F, 60.0F, 90.0F);
/*    */     }
/*    */   }
/*    */   
/*    */   public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException
/*    */   {
/* 48 */     if (enemyisAlive()) {
/* 49 */       Vector2f deltaSpeed = this.speed.copy();
/* 50 */       deltaSpeed.scale(delta / 2000.0F);
/* 51 */       this.position.add(deltaSpeed);
/*    */       
/* 53 */       this.lived += delta;
/* 54 */       if ((this.lived > LIFETIME) || (this.collision)) setEnemyAlive(false);
/*    */     }
/*    */   }
/*    */   
/*    */   public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {
/* 59 */     init(container, sbg);
/* 60 */     if (this.count == 1) {
/* 61 */       this.destroy = true;
/*    */     }
/*    */     else {
/* 64 */       this.destroy = false;
/*    */     }
/* 66 */     if (this.destroy) {
/* 67 */       setEnemyAlive(false);
/*    */     }
/*    */     
/* 70 */     if ((enemyisAlive()) && (this.enemy != null))
/*    */     {
/* 72 */       g.setColor(Color.black);
/* 73 */       g.drawImage(this.enemy, this.position.getX() - 10.0F, this.position.getY());
/* 74 */       g.setColor(Color.transparent);
/* 75 */       g.draw(this.boundingbox);
/*    */     }
/*    */   }
/*    */   
/* 79 */   public boolean enemyisAlive() { return this.alive; }
/*    */   
/*    */   public void setEnemyAlive(boolean alive) {
/* 82 */     this.alive = alive;
/*    */   }
/*    */ }