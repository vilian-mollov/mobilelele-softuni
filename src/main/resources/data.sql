INSERT INTO `brands` (`id`, `name`)
VALUES
    (1, 'Ford'),
    (2, 'Mercedes'),
    (3, 'Nissan'),
    (4, 'Audi'),
    (5, 'Bentley'),
    (6, 'Chevrolet'),
    (7, 'Lamborghini'),
    (8, 'Maserati'),
    (9, 'Ferrari'),
    (10, 'Porsche'),
    (11, 'Dodge'),
    (12, 'Jeep'),
    (13, 'Bugatti'),
    (14, 'Tesla'),
    (15, 'Citroen'),
    (16, 'Jaguar'),
    (17, 'Mazda'),
    (18, 'Lexus'),
    (19, 'Infiniti'),
    (20, 'Aston Martin'),
    (21, 'Rolls Royce'),
    (22, 'Toyota'),
    (23, 'McLaren');

INSERT INTO `models` (`id`, `category`, `brand_id`, `name`, `image_url`)
VALUES
    (1, 'Truck', 1, 'F150', '/images/F150.jpg'),
    (2, 'CAR', 23,  'GT', null),
    (3, 'CAR', 21,  'Phantom', null),
    (4, 'CAR', 21,  'Ghost', null),
    (5, 'CAR', 20,  'Vantage', null),
    (6, 'CAR', 12,  'Gladiator', null),
    (7, 'CAR', 3,   'GT-R', '/images/GT-R.jpg'),
    (8, 'CAR', 11,  'Challenger', null);

INSERT INTO `offers` (`id`, `description`, `engine`, `image_url`, `mileage`, `price`, `transmission`, `uuid`, `year`, `model_id`)
VALUES
    (1, 'GIGANTIC F150 ULTRA', 'DIESEL', '/images/F150.jpg', 20000, 80000, 'MANUAL', '550e8400-e29b-41d4-a716-446655440000', 2008, 1),
    (2, 'GT-R Batko mega lud', 'GASOLINE', '/images/GT-R.jpg', 50000, 180000, 'MANUAL', '550e8400-e29b-41d4-a716-446655440123', 2014, 7);

