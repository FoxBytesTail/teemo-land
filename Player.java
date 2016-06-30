/*    */ package game;
/*    */ 
/*    */ import org.lwjgl.input.Keyboard;
/*    */ import org.newdawn.slick.Animation;
/*    */ import org.newdawn.slick.GameContainer;
/*    */ import org.newdawn.slick.Graphics;
/*    */ import org.newdawn.slick.SpriteSheet;
/*    */ import org.newdawn.slick.state.StateBasedGame;
/*    */ 
/*    */ public class Player
/*    */ {
/*    */   public double x;
/*    */   public double y;
/*    */   public double yspeed;
/* 15 */   public int playerY = 537;
/*    */   public boolean isMovingRight;
/*    */   public boolean isMovingLeft;
/*    */   public boolean isNotMoving;
/*    */   public boolean isMoving;
/*    */   
/*    */   public void init(GameContainer container, StateBasedGame sbg) throws org.newdawn.slick.SlickException {
/* 22 */     this.playerSheetRight = new SpriteSheet("res/p1_walkleft.png", 90, 110);
/* 23 */     this.playerAnimationRight = new Animation(this.playerSheetRight, 125);
/*    */     
/* 25 */     this.playerSheetLeft = new SpriteSheet("res/p1_walk.png", 85, 110);
/* 26 */     this.playerAnimationLeft = new Animation(this.playerSheetLeft, 125);
/*    */   }
/*    */   
/* 29 */   public void update(GameContainer container, StateBasedGame sbg, int delta) throws org.newdawn.slick.SlickException { this.boundingbox = new org.newdawn.slick.geom.Rectangle(200.0F, this.playerY, 90.0F, 110.0F);
/* 30 */     if ((!Keyboard.isKeyDown(203)) || (!Keyboard.isKeyDown(205))) {
/* 31 */       this.playerAnimationLeft.stop();
/* 32 */       this.playerAnimationRight.stop();
/* 33 */       this.isMovingRight = false;
/* 34 */       this.isMovingLeft = false;
/* 35 */       this.isMoving = false;
/*    */     }
/* 37 */     if (Keyboard.isKeyDown(205)) {
/* 38 */       this.isMoving = true;
/* 39 */       this.x -= delta / 3.0D;
/* 40 */       this.playerAnimationRight.start();
/* 41 */       this.isMovingRight = true;
/*    */     }
/* 43 */     if (Keyboard.isKeyDown(203)) {
/* 44 */       this.x += delta / 3.0F;
/* 45 */       this.playerAnimationLeft.start();
/* 46 */       this.isMovingLeft = true;
/*    */     }
/* 48 */     physics(delta); }
/*    */   
/*    */   private SpriteSheet playerSheetRight;
/* 51 */   public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws org.newdawn.slick.SlickException { if (this.isMovingRight)
/* 52 */       this.playerAnimationRight.draw(200.0F, this.playerY);
/* 53 */     if (!this.isMovingLeft) {
/* 54 */       this.playerAnimationRight.draw(200.0F, this.playerY);
/*    */     }
/*    */     
/* 57 */     if (this.isMovingLeft)
/* 58 */       this.playerAnimationLeft.draw(200.0F, this.playerY);
/* 59 */     if (this.playerAnimationLeft.isStopped()) {
/* 60 */       this.playerAnimationLeft.stop();
/*    */     }
/* 62 */     g.setColor(org.newdawn.slick.Color.transparent);
/* 63 */     g.draw(this.boundingbox); }
/*    */   
/*    */   private SpriteSheet playerSheetLeft;
/*    */   
/* 67 */   public void physics(int delta) { this.playerY = ((int)(this.playerY - this.yspeed / delta));
/*    */     
/* 69 */     this.yspeed -= 0.009D / delta;
/* 70 */     if (this.playerY >= 537) {
/* 71 */       this.yspeed = 0.0D;
/* 72 */       this.playerY = 537;
/* 73 */       if (Keyboard.isKeyDown(200)) {
/* 74 */         this.yspeed += 2.25D;
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   private Animation playerAnimationRight;
/*    */   private Animation playerAnimationLeft;
/*    */   org.newdawn.slick.geom.Rectangle boundingbox;
/*    */ }
