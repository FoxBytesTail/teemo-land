/*    */ package game;
/*    */ 
/*    */ import org.newdawn.slick.AppGameContainer;
/*    */ import org.newdawn.slick.SlickException;
/*    */ 
/*    */ public class Game extends org.newdawn.slick.state.StateBasedGame
/*    */ {
/*    */   public static final String name = "Teemo Land";
/*  9 */   public static int menu = 0;
/* 10 */   public static int levelOne = 1;
/* 11 */   public static int credits = 2;
/*    */   
/*    */   public Game(String name) {
/* 14 */     super(name);
/* 15 */     addState(new Menu(menu));
/* 16 */     addState(new LevelOne(levelOne));
/* 17 */     addState(new Credits(credits));
/*    */   }
/*    */   
/*    */ 
/*    */   public void initStatesList(org.newdawn.slick.GameContainer container)
/*    */     throws SlickException
/*    */   {
/* 24 */     getState(menu).init(container, this);
/* 25 */     getState(levelOne).init(container, this);
/* 26 */     getState(credits).init(container, this);
/* 27 */     enterState(menu);
/*    */   }
/*    */   
/*    */ 
/*    */   public static void main(String[] args)
/*    */   {
/*    */     try
/*    */     {
/* 35 */       AppGameContainer display = new AppGameContainer(new Game("Teemo Land"), 1024, 768, false);
/* 36 */       display.start();
/* 37 */       display.setTargetFrameRate(60);
/*    */     }
/*    */     catch (SlickException localSlickException) {}
/*    */   }
/*    */ }