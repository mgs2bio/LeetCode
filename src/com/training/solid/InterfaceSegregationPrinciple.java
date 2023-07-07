package com.training.solid;

//the interface should be split in a way that the user/client would only have access to the necessary methods related to their needs.
public class InterfaceSegregationPrinciple {

    public interface TeacherBadExample {

        void English();

        void Biology();

        void Chemistry();

        void Mathematics();

    }

    public interface Teacher {

        void Teach();

    }

    public interface EnglishTeacher extends Teacher {

        void English();

    }

    public interface BiologyTeacher extends Teacher {

        void Bilogy();

    }

    public interface MathematicsTeacher extends Teacher {

        void Mathematics();

    }

    public class Jane implements EnglishTeacher {

        @Override
        public void Teach() {
            System.out.println("Jane has started teaching.");
        }

        @Override
        public void English() {
            System.out.println("Jane is teaching the students English language.");
        }

    }
}
