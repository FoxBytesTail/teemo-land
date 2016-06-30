/*    */ package game;
/*    */ 
/*    */ import org.newdawn.slick.Color;
/*    */ import org.newdawn.slick.GameContainer;
/*    */ import org.newdawn.slick.Graphics;
/*    */ import org.newdawn.slick.SlickException;
/*    */ import org.newdawn.slick.geom.Rectangle;
/*    */ import org.newdawn.slick.geom.Vector2f;
/*    */ import org.newdawn.slick.state.StateBasedGame;
/*    */ 
/*    */ public class Dart
/*    */ {
/*    */   public boolean collision;
/*    */   private Vector2f position;
/*    */   private Vector2f speed;
/* 16 */   Rectangle boundingbox = null;
/* 17 */   private static int LIFETIME = 1500;
/* 18 */   private int lived = 0;
/* 19 */   private boolean alive = true;
/*    */   
/*    */   public Dart(Vector2f position, Vector2f spd)
/*    */   {
/* 23 */     this.position = position;
/* 24 */     this.speed = spd;
/*    */   }
/*    */   
/* 27 */   public Dart() { setAlive(false); }
/*    */   
/*    */   public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException
/*    */   {
/* 31 */     if (isAlive()) {
/* 32 */       Vector2f deltaSpeed = this.speed.copy();
/* 33 */       deltaSpeed.scale(delta / 2000.0F);
/* 34 */       this.position.add(deltaSpeed);
/*    */       
/* 36 */       this.lived += delta;
/* 37 */       if (this.lived > LIFETIME) setAlive(false);
/*    */     }
/*    */   }
/*    */   
/*    */   public void init(GameContainer container, StateBasedGame sbg) throws SlickException
/*    */   {}
/*    */   
/*    */   public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {
/* 45 */     if (isAlive()) {
/* 46 */       this.boundingbox = new Rectangle(this.position.getX() - 10.0F, this.position.getY() - 10.0F, 30.0F, 5.0F);
/* 47 */       g.setColor(Color.black);
/* 48 */       g.fillOval(this.position.getX() - 10.0F, this.position.getY() - 10.0F, 30.0F, 5.0F);
/* 49 */       g.setColor(Color.transparent);
/* 50 */       g.draw(this.boundingbox);
/*    */     }
/*    */   }
/*    */   
/* 54 */   public boolean islive() { return isAlive(); }
/*    */   
/*    */   public boolean isAlive() {
/* 57 */     return this.alive;
/*    */   }
/*    */   
/* 60 */   public void setAlive(boolean alive) { this.alive = alive; }
/*    */ }