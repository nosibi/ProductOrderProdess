package com.OrderProcess.data;

public enum Grade {
    GOLD{
        @Override
        public int getDiscountRate() {
            return 30;
        }
    },
    SILVER{
        @Override
        public int getDiscountRate() {
            return 20;
        }
    },
    BRONZE{
        @Override
        public int getDiscountRate() {
            return 10;
        }
    };

    public abstract int getDiscountRate();
}