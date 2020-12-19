package com.company;

public class Main {

    /*
    Класс Thread
    Интерефейс Runnable
    synchronized
    wait() - поток в режиме ожидания
    notify() - возобновление потока в режиме спячки
    join() - ждет завершение потока
     */

    public static void main(String[] args) {
        new Main().start();
    }

    private volatile boolean flag = false;

    public void start() {
        new Thread(gui).start();
        System.out.println("Старт интерфейса!");
        new Thread(logic).start();
        System.out.println("Старт логики!");
    }

    // поток для интерфейса
    Runnable gui = new Runnable() {
        @Override
        public void run() {
            // отрисовка интерфейса
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = true;
            System.out.println("Стоп интерфейс!");
        }
    };

    Runnable logic = new Runnable() {
        @Override
        public void run() {
            // логика игры
            while(!flag) {
                // бесконечный цикл
            }
            System.out.println("Стоп логика!");
        }
    };



}


