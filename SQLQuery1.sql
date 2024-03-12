create database PolyDT_City;
drop database PolyDT_City;
use PolyDT_City;

CREATE TABLE Account (
    account_id INT PRIMARY KEY,
    full_name NVARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
	phone_number VARCHAR(100) NOT NULL,
	created_at Date NOT NULL,
	updated_at Date NOT NULL,
	is_active BIT NOT NULL DEFAULT 1
);

Create table Role (
	role_id INT PRIMARY KEY,
	role_name VARCHAR(50) NOT NULL,
	created_at Date NOT NULL,
	updated_at Date NOT NULL,
	is_active BIT NOT NULL DEFAULT 1,
);

Create table Authorize(
	role_id INT,
	account_id INT,
	PRIMARY KEY (role_id, account_id)		
);

ALTER TABLE Authorize
	ADD CONSTRAINT FK_1 FOREIGN KEY (role_id) REFERENCES Role(role_id);
ALTER TABLE Authorize
	ADD CONSTRAINT FK_2 FOREIGN KEY (account_id) REFERENCES Account(account_id);


create table Voucher(
	voucher_id INT,
	code NVARCHAR(50) UNIQUE  NOT NULL,
	value INT  NOT NULL,
	start_date DATE NOT NULL,
	end_date DATE NOT NULL,
	created_at DATE NOT NULL,
	updated_at DATE NOT NULL,
	quantity INT NOT NULL,
	description NVARCHAR(100) NOT NULL,
	is_active BIT NOT NULL DEFAULT 1,
	PRIMARY KEY (voucher_id)
);

create table Color(
	color_id int PRIMARY KEY,
	color_name NVARCHAR(100) NOT NULL,
	description NVARCHAR(100) NOT NULL,
	is_active BIT NOT NULL DEFAULT 1,
	created_at Date NOT NULL ,
  	updated_at Date NOT NULL 
);

create table Size(
	size_id int PRIMARY KEY,
	size_name NVARCHAR(100) NOT NULL,
	description NVARCHAR(100) NOT NULL,
	is_active BIT NOT NULL DEFAULT 1,
	created_at Date NOT NULL ,
  	updated_at Date NOT NULL 
);

create table Material(
	material_id int PRIMARY KEY,
	material_name NVARCHAR(100) NOT NULL,
	description NVARCHAR(100) NOT NULL,
	is_active BIT NOT NULL DEFAULT 1,
	created_at Date NOT NULL ,
  	updated_at Date NOT NULL 
);


create table ProductStatus(
	status_id int PRIMARY KEY,
	status_name NVARCHAR(100) NOT NULL,
	description NVARCHAR(100) NOT NULL,
	is_active BIT NOT NULL DEFAULT 1,
	created_at Date NOT NULL ,
  	updated_at Date NOT NULL 
);


create table Product(
	product_id int primary key,
	material_id int,
	status_id int,
	product_name NVARCHAR(50) NOT NULL,
	created_at Date NOT NULL ,
  	updated_at Date NOT NULL,
	url_image NVARCHAR(100) NOT NULL,
	description NVARCHAR(100) NOT NULL,
	FOREIGN KEY (material_id) REFERENCES Material (material_id), 
	FOREIGN KEY (status_id) REFERENCES ProductStatus (status_id)
);
Create table Discount (
	discount_id INT primary key,
	value INT  NOT NULL,
	start_date DATE NOT NULL,
	end_date DATE NOT NULL,
	created_at DATE NOT NULL,
	updated_at DATE NOT NULL,
	description NVARCHAR(100) NOT NULL,
	is_active BIT NOT NULL DEFAULT 1,
);


create table ProductDetails(
	product_details_id int PRIMARY KEY,
	color_id int,
	size_id int,
	product_id int,
	discount_id int,
	status_id int,
	price DECIMAL(10,2) NOT NULL,
	quantity NVARCHAR(100) NOT NULL,
	url_image NVARCHAR(100) NOT NULL,
	created_at Date NOT NULL ,
  	updated_at Date NOT NULL,
	FOREIGN KEY (color_id) REFERENCES Color (color_id),
	FOREIGN KEY (size_id) REFERENCES Size (size_id),
	FOREIGN KEY (product_id) REFERENCES Product (product_id),
	FOREIGN KEY (discount_id) REFERENCES Discount (discount_id),
	FOREIGN KEY (status_id) REFERENCES ProductStatus (status_id)
);

create table Customer(
	customer_id INT PRIMARY KEY,
	customer_name NVARCHAR(50) NOT NULL,
	address NVARCHAR(100) NOT NULL,
	point INT,
	phone_number VARCHAR(15),
	is_active BIT NOT NULL DEFAULT 1,
	updated_at DATE NOT NULL,
	created_at DATE NOT NULL
);

create table PaymentMethod(
	payment_method_id INT PRIMARY KEY,
	pay_name VARCHAR(50) NOT NULL,
	description NVARCHAR(100) NOT NULL,
	is_active BIT NOT NULL DEFAULT 1,
	updated_at DATE NOT NULL,
	created_at DATE NOT NULL
);

create table StatusOrder(
	status_order_id INT PRIMARY KEY,
	status_name NVARCHAR(50) NOT NULL,
	description NVARCHAR(100) NOT NULL,
	is_active BIT NOT NULL DEFAULT 1,
	updated_at DATE NOT NULL,
	created_at DATE NOT NULL
);


create table Orders(
	orders_id INT PRIMARY KEY,
	account_id INT,
	customer_id INT,
	payment_method_id INT,
	status_order_id INT,
	voucher_id INT,
	quantity INT NOT NULL,
	total DECIMAL(10,2) NOT NULL,
	discount DECIMAL(2,2) NOT NULL,
	total_cost DECIMAL(10,2) NOT NULL,
	customer_name NVARCHAR(50) NOT NULL,
	address NVARCHAR(50) NOT NULL,
	phone_number VARCHAR(15) NOT NULL,
	note NVARCHAR(100) NOT NULL,
	updated_at DATE NOT NULL,
	created_at DATE NOT NULL,
	FOREIGN KEY (account_id) REFERENCES Account (account_id),
	FOREIGN KEY (customer_id) REFERENCES Customer (customer_id),
	FOREIGN KEY (payment_method_id) REFERENCES PaymentMethod (payment_method_id),
	FOREIGN KEY (status_order_id) REFERENCES StatusOrder (status_order_id),
	FOREIGN KEY (voucher_id) REFERENCES Voucher (voucher_id)


);

create table Order_Details(
	order_details_id INT PRIMARY KEY,
	orders_id INT,
	product_details_id int,
	discount_id int,
	current_price DECIMAL(10,2),
	quantity INT NOT NULL,
	discount DECIMAL(2,2) NOT NULL,
	total DECIMAL(10,2) NOT NULL,
	total_cost DECIMAL(10,2) NOT NULL,
	status BIT NOT NULL DEFAULT 1,
	updated_at DATE NOT NULL,
	created_at DATE NOT NULL
	FOREIGN KEY (orders_id) REFERENCES Orders(orders_id),
	FOREIGN KEY (product_details_id) REFERENCES ProductDetails(product_details_id),
	FOREIGN KEY (discount_id) REFERENCES Discount(discount_id)
);


INSERT INTO Account (account_id, full_name, password, email, phone_number, created_at, updated_at, is_active)
VALUES
(1, 'John Doe', 'password123', 'john.doe@example.com', '1234567890', '2022-01-01', '2022-01-01', 1),
(2, 'Jane Smith', 'password456', 'jane.smith@example.com', '9876543210', '2022-01-02', '2022-01-02', 1),
(3, 'Mike Johnson', 'password789', 'mike.johnson@example.com', '5555555555', '2022-01-03', '2022-01-03', 1),
(4, 'Sarah Davis', 'passwordabc', 'sarah.davis@example.com', '1111111111', '2022-01-04', '2022-01-04', 1),
(5, 'Emily Wilson', 'passworddef', 'emily.wilson@example.com', '9999999999', '2022-01-05', '2022-01-05', 1);

INSERT INTO Role (role_id, role_name, created_at, updated_at, is_active)
VALUES
(1, 'Admin', '2022-01-01', '2022-01-01', 1),
(2, 'User', '2022-01-02', '2022-01-02', 1),
(3, 'Manager', '2022-01-03', '2022-01-03', 1),
(4, 'Guest', '2022-01-04', '2022-01-04', 1),
(5, 'Editor', '2022-01-05', '2022-01-05', 1);

INSERT INTO Authorize (role_id, account_id)
VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

INSERT INTO Voucher (voucher_id, code, value, start_date, end_date, created_at, updated_at, quantity, description, is_active)
VALUES
(1, 'VOUCHER01', 10, '2022-01-01', '2022-02-01', '2022-01-01', '2022-01-01', 100, 'Voucher 1', 1),
(2, 'VOUCHER02', 20, '2022-01-01', '2022-02-01', '2022-01-01', '2022-01-01', 200, 'Voucher 2', 1),
(3, 'VOUCHER03', 30, '2022-01-01', '2022-02-01', '2022-01-01', '2022-01-01', 300, 'Voucher 3', 1),
(4, 'VOUCHER04', 40, '2022-01-01', '2022-02-01', '2022-01-01', '2022-01-01', 400, 'Voucher 4', 1),
(5, 'VOUCHER05', 50, '2022-01-01', '2022-02-01', '2022-01-01', '2022-01-01', 500, 'Voucher 5', 1);

INSERT INTO Color (color_id, color_name, description, is_active, created_at, updated_at)
VALUES
(1, 'Red', 'Red color', 1, '2022-01-01', '2022-01-01'),
(2, 'Blue', 'Blue color', 1, '2022-01-02', '2022-01-02'),
(3, 'Green', 'Green color', 1, '2022-01-03', '2022-01-03'),
(4, 'Yellow', 'Yellow color', 1, '2022-01-04', '2022-01-04'),
(5, 'Black', 'Black color', 1, '2022-01-05', '2022-01-05');

INSERT INTO Size (size_id, size_name, description, is_active, created_at, updated_at)
VALUES
(1, 'Small', 'Small size', 1, '2022-01-01', '2022-01-01'),
(2, 'Medium', 'Medium size', 1, '2022-01-02', '2022-01-02'),
(3, 'Large', 'Large size', 1, '2022-01-03', '2022-01-03'),
(4, 'XL', 'XL size', 1, '2022-01-04', '2022-01-04'),
(5, 'XXL', 'XXL size', 1, '2022-01-05', '2022-01-05');

INSERT INTO Material (material_id, material_name, description, is_active, created_at, updated_at)
VALUES
(1, 'Cotton', 'Cotton material', 1, '2022-01-01', '2022-01-01'),
(2, 'Polyester', 'Polyester material', 1, '2022-01-02', '2022-01-02'),
(3, 'Silk', 'Silk material', 1, '2022-01-03', '2022-01-03'),
(4, 'Wool', 'Wool material', 1, '2022-01-04', '2022-01-04'),
(5, 'Leather', 'Leather material', 1, '2022-01-05', '2022-01-05');

INSERT INTO ProductStatus (status_id, status_name, description, is_active, created_at, updated_at)
VALUES
(1, 'Available', 'Product is available', 1, '2022-01-01', '2022-01-01'),
(2, 'Out of Stock', 'Product is out of stock', 1, '2022-01-02', '2022-01-02'),
(3, 'Discontinued', 'Product is discontinued', 1, '2022-01-03', '2022-01-03'),
(4, 'Coming Soon', 'Product is coming soon', 1, '2022-01-04', '2022-01-04'),
(5, 'Limited Edition', 'Product is limited edition', 1, '2022-01-05', '2022-01-05');

INSERT INTO Product (product_id, material_id, status_id, product_name, created_at, updated_at, url_image, description)
VALUES
(1, 1, 1, 'Product 1', '2022-01-01', '2022-01-01', 'image1.jpg', 'Description 1'),
(2, 2, 2, 'Product 2', '2022-01-02', '2022-01-02', 'image2.jpg', 'Description 2'),
(3, 3, 3, 'Product 3', '2022-01-03', '2022-01-03', 'image3.jpg', 'Description 3'),
(4, 4, 4, 'Product 4', '2022-01-04', '2022-01-04', 'image4.jpg', 'Description 4'),
(5, 5, 5, 'Product 5', '2022-01-05', '2022-01-05', 'image5.jpg', 'Description 5');

INSERT INTO Discount (discount_id, value, start_date, end_date, created_at, updated_at, description, is_active)
VALUES
(1, 10, '2022-01-01', '2022-02-01', '2022-01-01', '2022-01-01', 'Discount 1', 1),
(2, 20, '2022-01-01', '2022-02-01', '2022-01-01', '2022-01-01', 'Discount 2', 1),
(3, 30, '2022-01-01', '2022-02-01', '2022-01-01', '2022-01-01', 'Discount 3',1 )

INSERT INTO ProductDetails (product_details_id, color_id, size_id, product_id, discount_id, status_id, price, quantity, url_image, created_at, updated_at)
VALUES
(1, 1, 1, 1, 1, 1, 49.99, '10', 'image1.jpg', '2022-01-01', '2022-01-01'),
(2, 2, 2, 2, 2, 2, 59.99, '20', 'image2.jpg', '2022-01-02', '2022-01-02'),
(3, 3, 3, 3, 3, 3, 69.99, '30', 'image3.jpg', '2022-01-03', '2022-01-03'),
(4, 4, 4, 4, null, 4, 79.99, '40', 'image4.jpg', '2022-01-04', '2022-01-04'),
(5, 5, 5, 5, null, 5, 89.99, '50', 'image5.jpg', '2022-01-05', '2022-01-05');

INSERT INTO Customer (customer_id, customer_name, address, point, phone_number, is_active, updated_at, created_at)
VALUES
(1, 'John Doe', '123 Main St', 100, '1234567890', 1, '2022-01-01', '2022-01-01'),
(2, 'Jane Smith', '456 Elm St', 200, '0987654321', 1, '2022-01-02', '2022-01-02'),
(3, 'Mike Johnson', '789 Oak St', 300, '5555555555', 1, '2022-01-03', '2022-01-03'),
(4, 'Amy Davis', '321 Pine St', 400, '9999999999', 1, '2022-01-04', '2022-01-04'),
(5, 'Chris Wilson', '654 Maple St', 500, '1111111111', 1, '2022-01-05', '2022-01-05');

INSERT INTO PaymentMethod (payment_method_id, pay_name, description, is_active, updated_at, created_at)
VALUES
(1, 'Credit Card', 'Payment by credit card', 1, '2022-01-01', '2022-01-01'),
(2, 'PayPal', 'Payment via PayPal', 1, '2022-01-02', '2022-01-02'),
(3, 'Bank Transfer', 'Payment by bank transfer', 1, '2022-01-03', '2022-01-03'),
(4, 'Cash on Delivery', 'Payment upon delivery', 1, '2022-01-04', '2022-01-04'),
(5, 'Gift Card', 'Payment using gift card', 1, '2022-01-05', '2022-01-05');

INSERT INTO StatusOrder (status_order_id, status_name, description, is_active, updated_at, created_at)
VALUES
(1, 'Pending', 'Order is pending', 1, '2022-01-01', '2022-01-01'),
(2, 'Processing', 'Order is being processed', 1, '2022-01-02', '2022-01-02'),
(3, 'Shipped', 'Order has been shipped', 1, '2022-01-03', '2022-01-03'),
(4, 'Delivered', 'Order has been delivered', 1, '2022-01-04', '2022-01-04'),
(5, 'Cancelled', 'Order has been cancelled', 1, '2022-01-05', '2022-01-05');

INSERT INTO Orders (orders_id, account_id, customer_id, payment_method_id, status_order_id, voucher_id, quantity, total, discount, total_cost, customer_name, address,phone_number, note, updated_at, created_at)
VALUES
(1, 1, 1, 1, 1, 1, 2, 99.98, 0.05, 94.98, 'John Doe', '123 Main St', '1234567890', 'Note 1', '2022-01-01', '2022-01-01'),
(2, 2, 2, 2, 2, 2, 3, 149.97, 0.1, 134.97, 'Jane Smith', '456 Elm St', '0987654321', 'Note 2', '2022-01-02', '2022-01-02'),
(3, 3, 3, 3, 3, 3, 1, 69.99, 0, 69.99, 'Mike Johnson', '789 Oak St', '5555555555', 'Note 3', '2022-01-03', '2022-01-03'),
(4, 4, 4, 4, 4, 4, 5, 399.95, 0.2, 319.96, 'Amy Davis', '321 Pine St', '9999999999', 'Note 4', '2022-01-04', '2022-01-04'),
(5, 5, 5, 5, 5, 5, 4, 319.96, 0.15, 271.97, 'Chris Wilson', '654 Maple St', '1111111111', 'Note 5', '2022-01-05', '2022-01-05');

INSERT INTO Order_Details (order_details_id, orders_id, product_details_id, discount_id, current_price, quantity, discount, total, total_cost, status, updated_at, created_at)
VALUES
(1, 1, 1, 1, 49.99, 2, 0.05, 99.98, 94.98, 1, '2022-01-01', '2022-01-01'),
(2, 2, 2, 2, 59.99, 3, 0.1, 179.97, 134.97, 1, '2022-01-02', '2022-01-02'),
(3, 3, 3, 3, 69.99, 1, 0, 69.99, 69.99, 1, '2022-01-03', '2022-01-03'),
(4, 4, 4, null, 79.99, 5, 0.2, 399.95, 319.96, 1, '2022-01-04', '2022-01-04'),
(5, 5, 5, null, 89.99, 4, 0.15, 359.96, 271.97, 1, '2022-01-05', '2022-01-05');