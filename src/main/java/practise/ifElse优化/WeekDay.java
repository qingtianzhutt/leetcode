package practise.ifElse优化;

/**
 * 定义了一周的每一天要干什么
 */
enum WeekDay {
    /**星期天要作甚？*/
    Sunday("Sunday"){
        @Override
        void weekRun() {
            System.out.println(weekName + "：和朋友出去玩！");
        }
    },
    /**星期1要作甚？*/
    Monday("Monday"){
        @Override
        void weekRun() {
            System.out.println(weekName + "：在学校学习英语");
        }
    },
    /**星期2要作甚？*/
    Tuesday("Tuesday"){
        @Override
        void weekRun() {
            System.out.println(weekName + "：在学校学习java");
        }
    },
    /**星期3要作甚？*/
    Wednesday("Wednesday"){
        @Override
        void weekRun() {
            System.out.println(weekName + "：在学校学习语文");
        }
    },
    /**星期4要作甚？*/
    Thursday("Thursday"){
        @Override
        void weekRun() {
            System.out.println(weekName + "：在学校学习历史");
        }
    },
    /**星期5要作甚？*/
    Friday("Friday"){
        @Override
        void weekRun() {
            System.out.println(weekName + "在学校玩");
        }
    },
    /**星期6要作甚？*/
    Saturday("Saturday"){
        @Override
        void weekRun() {
            System.out.println(weekName + "和朋友在家看电影");
        }
    };

    public String weekName;
    abstract void weekRun();
    WeekDay(String weekName){
        this.weekName = weekName;
    }
}

