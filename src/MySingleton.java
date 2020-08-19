public class MySingleton {
    private volatile static MySingleton uniqueInstance;

    private MySingleton() {
    }

    public synchronized static MySingleton getUniqueInstance() {
        //先判断对象是否已经实例过，没有实例化过才进⼊加锁代码
        if (uniqueInstance == null) {
            //类对象加锁
            synchronized (MySingleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new MySingleton();
                }
            }
        }
        return uniqueInstance;
    }
}

















