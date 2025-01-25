class ParkingSystem {
     public enum CarType {
        BIG {
            @Override
            public boolean park(ParkingSystem system) {
                if (system.big > 0) {
                    system.big--;
                    return true;
                }
                return false;
            }
        },
        MEDIUM {
            @Override
            public boolean park(ParkingSystem system) {
                if (system.medium > 0) {
                    system.medium--;
                    return true;
                }
                return false;
            }
        },
        SMALL {
            @Override
            public boolean park(ParkingSystem system) {
                if (system.small > 0) {
                    system.small--;
                    return true;
                }
                return false;
            }
        };

        public abstract boolean park(ParkingSystem system);

        public static CarType fromType(int type) {
            switch (type) {
                case 1: return BIG;
                case 2: return MEDIUM;
                case 3: return SMALL;
                default: throw new IllegalArgumentException("Invalid car type: " + type);
            }
        }
    }

    private int big;
    private int medium;
    private int small;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        return CarType.fromType(carType).park(this);
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */