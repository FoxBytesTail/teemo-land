/*    */ package game;
/*    */ 
/*    */ import org.newdawn.slick.Color;
/*    */ import org.newdawn.slick.GameContainer;
/*    */ import org.newdawn.slick.Graphics;
/*    */ import org.newdawn.slick.Image;
/*    */ import org.newdawn.slick.SlickException;
/*    */ import org.newdawn.slick.state.BasicGameState;
/*    */ import org.newdawn.slick.state.StateBasedGame;
/*    */ 
/*    */ 
/*    */ public class Credits
/*    */   extends BasicGameState
/*    */ {
/*    */   private Image deadTeemo;
/*    */   float mouseX;
/*    */   float mouseY;
/*    */   boolean start;
/*    */   
/*    */   public Credits(int State) {}
/*    */   
/*    */   public void init(GameContainer container, StateBasedGame sbg)
/*    */     throws SlickException
/*    */   {
/* 25 */     this.deadTeemo = new Image("res/deadTeemo.png");
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void render(GameContainer container, StateBasedGame sbg, Graphics g)
/*    */     throws SlickException
/*    */   {
/* 33 */     g.setColor(Color.white);
/* 34 */     g.setBackground(Color.decode("#993300"));
/* 35 */     this.deadTeemo.draw(0.0F, 0.0F, 0.75F);
/* 36 */     g.drawString("You are Dead!", 550.0F, 150.0F);
/* 37 */     g.drawString("Images Used in this Game are copyright", 550.0F, 200.0F);
/* 38 */     g.drawString("of their respected owners", 550.0F, 225.0F);
/* 39 */     g.drawString("Game made by Youngmin Lee for IB Computer Science", 550.0F, 275.0F);
/*    */   }
/*    */   
/*    */   public void update(GameContainer container, StateBasedGame sbg, int delta)
/*    */     throws SlickException
/*    */   {}
/*    */ 
/*    */   public int getID()
/*    */   {
/* 68 */     return 2;
/*    */   }
/*    */ }