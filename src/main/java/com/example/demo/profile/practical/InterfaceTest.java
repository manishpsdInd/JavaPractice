package com.example.demo.profile.practical;

public class InterfaceTest {
    //interface Gift  { void present(); }
    //interface Gift  { boolean present(); }
	@FunctionalInterface
	interface Gift {
		void future();
		default void present() {
			System.out.println("Gift.present");
		};
		default void past() {
			System.out.println("Gift.past");
		};
	}
    interface Guest  { default void present() {System.out.println("Guest");}; }
    //interface Guest { void present(); }

    interface Presentable extends Gift, Guest {

		@Override
		default void present() {
			// TODO Auto-generated method stub
			Gift.super.present();
		} }

    public static void main(String[] args) {
        Presentable johnny = new Presentable() {
            @Override public void present() {
                System.out.println("Heeeereee's Johnny!!!");
            }
        };
        johnny.present();                     // "Heeeereee's Johnny!!!"

        ((Gift) johnny).present();            // "Heeeereee's Johnny!!!"
        ((Guest) johnny).present();           // "Heeeereee's Johnny!!!"

        Gift johnnyAsGift = (Gift) johnny;
        johnnyAsGift.present();               // "Heeeereee's Johnny!!!"

        Guest johnnyAsGuest = (Guest) johnny;
        johnnyAsGuest.present();              // "Heeeereee's Johnny!!!"
    }
}