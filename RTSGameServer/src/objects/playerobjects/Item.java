package objects.playerobjects;

import java.io.Serializable;

public enum Item implements Serializable {

                // Item IDs

        // Speed-Ups
    SPEED_UP_1_MIN(0),
        SPEED_UP_5_MIN(1),
            SPEED_UP_10_MIN(2),
                SPEED_UP_15_MIN(3),
                    SPEED_UP_30_MIN(4),
                        SPEED_UP_1_HR(5),
                            SPEED_UP_3_HR(6),
                                SPEED_UP_8_HR(7),
                                    SPEED_UP_15_HR(8),
                                        SPEED_UP_1_DAY(9),
                                            SPEED_UP_3_DAY(10),
                                                SPEED_UP_7_DAY(10),
                                                    SPEED_UP_15_DAY(11),
                                                        SPEED_UP_30_DAY(12),

        // Food
    RESOURCE_FOOD_1000(13),
        RESOURCE_FOOD_5000(14),
            RESOURCE_FOOD_10000(15),
                RESOURCE_FOOD_15000(16),
                    RESOURCE_FOOD_25000(17),
                        RESOURCE_FOOD_50000(18),
                            RESOURCE_FOOD_100000(19),
                                RESOURCE_FOOD_150000(20),
                                    RESOURCE_FOOD_250000(21),
                                        RESOURCE_FOOD_500000(22),
                                            RESOURCE_FOOD_1000000(23),
                                                RESOURCE_FOOD_1500000(24),
                                                    RESOURCE_FOOD_2500000(25),
                                                        RESOURCE_FOOD_5000000(26),
                                                            RESOURCE_FOOD_10000000(27),
                                                                RESOURCE_FOOD_25000000(28),

        // Wood
    RESOURCE_WOOD_1000(29),
        RESOURCE_WOOD_5000(30),
            RESOURCE_WOOD_10000(31),
                RESOURCE_WOOD_15000(32),
                    RESOURCE_WOOD_25000(33),
                        RESOURCE_WOOD_50000(34),
                            RESOURCE_WOOD_100000(35),
                                RESOURCE_WOOD_150000(36),
                                    RESOURCE_WOOD_250000(37),
                                        RESOURCE_WOOD_500000(38),
                                            RESOURCE_WOOD_1000000(39),
                                                RESOURCE_WOOD_1500000(40),
                                                    RESOURCE_WOOD_2500000(41),
                                                        RESOURCE_WOOD_5000000(42),
                                                            RESOURCE_WOOD_10000000(43),
                                                                RESOURCE_WOOD_25000000(44),

        // Stone
    RESOURCE_STONE_1000(45),
        RESOURCE_STONE_5000(46),
            RESOURCE_STONE_10000(47),
                RESOURCE_STONE_15000(48),
                    RESOURCE_STONE_25000(49),
                        RESOURCE_STONE_50000(50),
                            RESOURCE_STONE_100000(51),
                                RESOURCE_STONE_150000(52),
                                    RESOURCE_STONE_250000(53),
                                        RESOURCE_STONE_500000(54),
                                            RESOURCE_STONE_1000000(55),
                                                RESOURCE_STONE_1500000(56),
                                                    RESOURCE_STONE_2500000(57),
                                                        RESOURCE_STONE_5000000(58),
                                                            RESOURCE_STONE_10000000(59),
                                                                RESOURCE_STONE_25000000(60),

        // Silver
    RESOURCE_SILVER_1000(61),
        RESOURCE_SILVER_5000(62),
            RESOURCE_SILVER_10000(63),
                RESOURCE_SILVER_15000(64),
                    RESOURCE_SILVER_25000(65),
                        RESOURCE_SILVER_50000(66),
                            RESOURCE_SILVER_100000(67),
                                RESOURCE_SILVER_150000(68),
                                    RESOURCE_SILVER_250000(69),
                                        RESOURCE_SILVER_500000(70),
                                            RESOURCE_SILVER_1000000(71),
                                                RESOURCE_SILVER_1500000(72),
                                                    RESOURCE_SILVER_2500000(73),
                                                        RESOURCE_SILVER_5000000(74),
                                                            RESOURCE_SILVER_10000000(74),
                                                                RESOURCE_SILVER_25000000(76),

        // Teleports
    TELEPORT_RANDOM(77),
        TELEPORT_ADVANCED(78),
            TELEPORT_BEGINNER(79),
                TELEPORT_KINGDOM(80),

        // Combat Attack
    BOOST_ATTACK_15_4HOUR(81),
        BOOST_ATTACK_15_DAY(82),
            BOOST_ATTACK_25_4HOUR(83),
                BOOST_ATTACK_25_DAY(84),

        // Combat Defence
    BOOST_DEFENCE_15_4HOUR(85),
        BOOST_DEFENCE_15_DAY(86),
            BOOST_DEFENCE_25_4HOUR(87),
                BOOST_DEFENCE_25_DAY(88),

        // March Items
    BOOST_MARCH_SPEED_25(89),
        BOOST_MARCH_SPEED_50(90),
            BOOST_MARCH_SIZE_25_HOUR(91),
                BOOST_MARCH_SIZE_25_4HOUR(92),
                    BOOST_MARCH_SIZE_50_HOUR(93),
                        BOOST_MARCH_SIZE_50_4HOUR(94),

        // Gather/Resource Boosts
    BOOST_PRODUCE_FOOD_25_DAY(95),
        BOOST_PRODUCE_FOOD_25_WEEK(96),
            BOOST_PRODUCE_WOOD_25_DAY(97),
                BOOST_PRODUCE_WOOD_25_WEEK(98),
                    BOOST_PRODUCE_STONE_25_DAY(99),
                        BOOST_PRODUCE_STONE_25_WEEK(100),
                            BOOST_PRODUCE_SILVER_25_DAY(101),
                                BOOST_PRODUCE_SILVER_25_WEEK(102),
                                    BOOST_GATHER_25_DAY(103),
                                        BOOST_GATHER_25_WEEK(104),

        // Shields


        // Material Chests


        // Misc


    ;

                // End Item IDs

    private static final long serialVersionUID = -942038562193532152L;



    private int id;

    Item(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Item{" +
                " id=" + id +
                '}';
    }
}
