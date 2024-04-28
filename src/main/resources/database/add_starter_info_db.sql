INSERT INTO tb_menu(name, menu_type, calories, price, carbohydrates, structure)
VALUES ('Борщ', 'Food', 57.7, 200, 4.3, 'Капуста, картофель, соль, лавровый лист, зелень, чеснок, черный перец');
INSERT INTO tb_menu(name, menu_type, calories, price, carbohydrates, structure, strength)
VALUES ('Чай', 'Drink', 1, 30, 0.2, 'Трава', 0);
INSERT INTO tb_menu(name, menu_type, calories, price, carbohydrates, structure, strength)
VALUES ('Мохито', 'Drink', 96, 100, 17.0, 'Белый ром, сахарный сироп, содовая, лайм, мята, дробленый лед', 0);

INSERT INTO tb_category(name)
VALUES ('Первое');
INSERT INTO tb_category(name)
VALUES ('Супы');
INSERT INTO tb_category(name)
VALUES ('Безалкогольные напитки');
INSERT INTO tb_category(name)
VALUES ('Алкогольные напитки');

INSERT INTO tb_category_menu(menu_id, category_id)
VALUES (1, 1);
INSERT INTO tb_category_menu(menu_id, category_id)
VALUES (1, 2);
INSERT INTO tb_category_menu(menu_id, category_id)
VALUES (2, 3);
INSERT INTO tb_category_menu(menu_id, category_id)
VALUES (3, 4);