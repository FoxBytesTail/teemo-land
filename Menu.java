/*    */ package game;
/*    */ 
/*    */ import org.lwjgl.input.Mouse;
/*    */ import org.newdawn.slick.GameContainer;
/*    */ import org.newdawn.slick.Graphics;
/*    */ import org.newdawn.slick.Image;
/*    */ import org.newdawn.slick.SlickException;
/*    */ import org.newdawn.slick.state.StateBasedGame;
/*    */ 
/*    */ public class Menu extends org.newdawn.slick.state.BasicGameState
/*    */ {
/*    */   Image play1;
/*    */   Image play2;
/*    */   boolean start;
/*    */   float mouseX;
/*    */   float mouseY;
/*    */   private Image teemo;
/*    */   
/*    */   public Menu(int State) {}
/*    */   
/*    */   public void init(GameContainer container, StateBasedGame sbg) throws SlickException
/*    */   {
/* 23 */     this.play1 = new Image("res/Play Button 1.png");
/* 24 */     this.play2 = new Image("res/Play Button 2.png");
/* 25 */     this.teemo = new Image("res/teemobruh.png");
/*    */   }
/*    */   
/*    */   public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {
/* 29 */     g.drawString("Welcome to Teemo Land", 418.0F, 100.0F);
/* 30 */     g.drawString("How to Play:", 50.0F, 150.0F);
/* 31 */     g.drawString("Press Space to Fire Darts", 50.0F, 175.0F);
/* 32 */     g.drawString("Press Left or Right Arrow Keys", 50.0F, 200.0F);
/* 33 */     g.drawString("to move", 50.0F, 225.0F);
/* 34 */     g.drawString("Press Up to Jump", 50.0F, 250.0F);
/* 35 */     g.drawString("Don't let the Minions reach the end of the screen!", 50.0F, 300.0F);
/*    */     
/* 37 */     g.setBackground(org.newdawn.slick.Color.decode("#0066CC"));
/* 38 */     g.setColor(org.newdawn.slick.Color.white);
/*    */     
/* 40 */     g.drawImage(this.teemo, 600.0F, 300.0F);
/* 41 */     if (this.start) {
/* 42 */       g.drawImage(this.play1, 362.0F, 150.0F);
/*    */     } else {
/* 44 */       g.drawImage(this.play2, 362.0F, 150.0F);
/*    */     }
/*    */   }
/*    */   
/*    */   public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {
/* 49 */     this.mouseX = Mouse.getX();
/* 50 */     this.mouseY = Mouse.getY();
/*    */     
/*    */ 
/* 53 */     if ((this.mouseX > 362.0F) && (this.mouseX < 662.0F) && (this.mouseY > 468.0F) && (this.mouseY < 618.0F)) {
/* 54 */       this.start = true;
/* 55 */       if (Mouse.isButtonDown(0)) {
/* 56 */         sbg.enterState(1);
/*    */       }
/*    */     } else {
/* 59 */       this.start = false;
/*    */     }
/*    */   }
/*    */   
/*    */   public int getID()
/*    */   {
/* 65 */     return 0;
/*    */   }
/*    */ }