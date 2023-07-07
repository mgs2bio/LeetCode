package com.training.solid;

//every class, module, or function in a program should have one responsibility/purpose in a program
public class SingleResponsibilityPrinciple {
    //bad example
    public class Student {

        public void registerStudent() {
            // some logic
        }

        public void calculate_Student_Results() {
            // some logic
        }

        public void sendEmail() {
            // some logic
        }

    }

    //Good Examples
    public class StudentRegister {
        public void registerStudent() {
            // some logic
        }
    }
    public class StudentResult {
        public void calculate_Student_Result() {
            // some logic
        }
    }
    public class StudentEmails {
        public void sendEmail() {
            // some logic
        }
    }
}
