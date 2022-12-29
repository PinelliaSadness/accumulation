package com.lym.redis;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.ClusterServersConfig;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

public class SimpleMain {

    public static void main(String[] args) {

        Config config = new Config();
        ClusterServersConfig clusterServersConfig = config.useClusterServers();
        clusterServersConfig.setScanInterval(2000) // 集群状态扫描间隔时间，单位是毫秒
                .setPassword("sfakjfiju99jjf87LJSDDU8")//密码
                .setTimeout(6000);

        config.useClusterServers()
                .addNodeAddress("redis://redis01.dev01.wyc.ws.srv:6379", "redis://redis02.dev01.wyc.ws.srv:6380", "redis://redis03.dev01.wyc.ws.srv:6380");
        RedissonClient redissonClient = Redisson.create(config);
        System.out.println("redissonClient链接成功");

        int leaseTime = 10;
        lock(redissonClient, leaseTime);

    }


    private static void lock(RedissonClient redissonClient, int leaseTime) {

        String lock = "lock_00";

        RLock rLock = redissonClient.getLock(lock);
        boolean locked0 = rLock.isLocked();
        System.out.println("加锁了吗" + locked0);

        for (int i=0;i<100;i++){

            rLock.lock(leaseTime,  TimeUnit.SECONDS);
            if (rLock.isLocked()){
                System.out.println("加锁了" + i + "不能进行业务操作");
            }
        }

        if (!rLock.isHeldByCurrentThread()) {
            throw new RuntimeException("释放锁失败，非当前线程持的有锁");
        }

        for (int i=0;i<100;i++) {

            if (rLock.isLocked()) {
                rLock.unlock();
                System.out.println("加锁了吗"+rLock.isLocked());
            }
        }
        // 这里锁还能继续加锁,加了几次,就要释放几次,不能一次行全部释放

        if ( !rLock.isLocked()){
            System.out.println("锁释放了,进行业务操作");
        }

        System.exit(-1);
    }

}
