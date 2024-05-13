package com.lym.socket;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class WOW {
    public static void main(String[] args) {
        for (int playerLevel = 1; playerLevel <60; playerLevel++){
            int base = getBase(playerLevel);
//            int lessLevel = getLessLevel(playerLevel);
            int killLevel = playerLevel;

            int exp = getMonsterExperience(killLevel);
            double proportion = getExperience(playerLevel, killLevel, base);
            int expForMonsterLevel = new BigDecimal(exp )
                    .multiply(new BigDecimal(proportion))
                    .multiply(new BigDecimal("0.65"))
                    .setScale(0, RoundingMode.FLOOR).intValue();
            System.out.print(" 人物等级=" + playerLevel);
//            System.out.print(" 最低获得经验怪物等级=" + lessLevel);
            System.out.print(" 击杀怪物等级=" + killLevel);
            System.out.print(" 怪物经验=" + exp);
            System.out.print(" 经验比例=" + proportion);
            System.out.println(" 当前获得经验=" + expForMonsterLevel);

        }
    }

    private static double getExperience(int playerLevel, int monsterLevel, int base) {
        if (monsterLevel > playerLevel){
            int levelGap = monsterLevel - playerLevel;
            if (levelGap < 5){
                return 1 + levelGap * 0.05;
            } else {
                return 1.2;
            }
        } else {
            int lessLevel = getLessLevel(playerLevel);
            if(monsterLevel < lessLevel ){
                return 0;
            }
        }
        return new BigDecimal(1d - ((double)(playerLevel - monsterLevel) /base)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    private static int getLessLevel(int playerLevel) {
        int lessLevel;
        int t = playerLevel /10;
        if (playerLevel < 5 ){
            lessLevel = 1;
        } else if (playerLevel < 50 ){
            lessLevel = (playerLevel - t ) - 5 +1;
        } else if (playerLevel == 50 ){
            lessLevel = playerLevel - 10 + 1;
        } else {
            lessLevel = playerLevel - 11 +1;
        }
        return lessLevel;
    }

    private static int getMonsterExperience(int monsterLevel){
        return (monsterLevel * 5) + 45;
    }


    private static int getBase(int playerLevel) {
        int base = 0;
        if (playerLevel < 8){
            base = 5;
        } else if (playerLevel < 10){
            base = 6;
        }else if (playerLevel < 12){
            base = 7;
        }else if (playerLevel < 16){
            base = 8;
        }else if (playerLevel < 20){
            base = 9;
        }else if (playerLevel < 30){
            base = 11;
        }else if (playerLevel < 40){
            base = 12;
        }else if (playerLevel < 45){
            base = 13;
        }else if (playerLevel < 50){
            base = 14;
        }else if (playerLevel < 55){
            base = 15;
        }else if (playerLevel < 60){
            base = 16;
        }
        return base;
    }
}
