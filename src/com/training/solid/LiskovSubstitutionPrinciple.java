package com.training.solid;

import java.util.concurrent.CompletableFuture;

//objects of a superclass should be replaceable with objects of its subclasses without breaking the application
public class LiskovSubstitutionPrinciple {

    public class Amphibian {

        public void swim() {
        }

        public void walk() {
        }


    }

    public class Frog extends Amphibian {
        public void swim() {
            System.out.println("The frog is swimming");
        }

        public void walk() {
            System.out.println("The frog is walking on land");
        }
    }

    //this violates LSP since dolphin doesn't inherit all the natures of Amphibian such as walk.
    //so the application would break if Amphibian is replaced by Dolphin.
    public class Dolphin extends Amphibian {
        public void swim() {
            System.out.println("The Dolphin is swimming");
        }

        public void walk() {
            System.out.println("The Dolphin Cannot walk");
        }
    }
}
