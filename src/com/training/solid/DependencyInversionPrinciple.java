package com.training.solid;

//The principle of dependency inversion refers to the decoupling of software modules.
//This way, instead of high-level modules depending on low-level modules, both will depend on abstractions
public class DependencyInversionPrinciple {

   //bad
//    public class Windows98Machine {
//
//        private final StandardKeyboard keyboard;
//        private final Monitor monitor;
//
//        public Windows98Machine() {
//            monitor = new Monitor();
//            keyboard = new StandardKeyboard();
//        }
//
//    }


    //good

//    public class Windows98Machine{
//
//        private final Keyboard keyboard;
//        private final Monitor monitor;
//
//        public Windows98Machine(Keyboard keyboard, Monitor monitor) {
//            this.keyboard = keyboard;
//            this.monitor = monitor;
//        }
//    }

//    public class StandardKeyboard implements Keyboard { }
}
