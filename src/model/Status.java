package model;
    public enum Status {
        TODO,
        DOING,
        DONE;

        @Override
        public String toString() {
            return name().charAt(0) + name().substring(1).toLowerCase().replace("_", " ");
        }
    }
