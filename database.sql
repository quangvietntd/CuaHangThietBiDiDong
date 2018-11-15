-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Máy chủ: localhost:3306
-- Thời gian đã tạo: Th6 20, 2018 lúc 11:57 AM
-- Phiên bản máy phục vụ: 10.1.31-MariaDB
-- Phiên bản PHP: 7.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `id6110822_cuahangthietbi`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietdonhang`
--

CREATE TABLE `chitietdonhang` (
  `id` int(11) NOT NULL,
  `madonhang` int(11) NOT NULL,
  `masanpham` int(11) NOT NULL,
  `tensanpham` varchar(2000) NOT NULL,
  `giasanpham` int(11) NOT NULL,
  `soluongsanpham` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `chitietdonhang`
--

INSERT INTO `chitietdonhang` (`id`, `madonhang`, `masanpham`, `tensanpham`, `giasanpham`, `soluongsanpham`) VALUES
(1, 17, 2, 'Điện thoại ASUS Zenfone Max Plus M1 - ZB570TL', 27450000, 5),
(2, 18, 1, 'Điện thoại iPhone X 256GB', 104370000, 3),
(3, 18, 2, 'Điện thoại ASUS Zenfone Max Plus M1 - ZB570TL', 5490000, 1),
(4, 19, 42, 'Laptop HP Envy 13 ad158TU i5 8250U/4GB/128GB/Win10/(3MR80PA)', 19990000, 1),
(5, 19, 1, 'Điện thoại iPhone X 256GB', 34790000, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `donhang`
--

CREATE TABLE `donhang` (
  `id` int(11) NOT NULL,
  `tenkhachhang` varchar(200) NOT NULL,
  `sodienthoai` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `donhang`
--

INSERT INTO `donhang` (`id`, `tenkhachhang`, `sodienthoai`, `email`) VALUES
(1, 'phat', '123123123', 'phat@gmail.com'),
(2, 'Anh', '89461652', 'quangvietntd@gmail.com'),
(3, 'Anh', '89461652', 'quangvietntd@gmail.com'),
(4, 'nhut', '89461652', 'quangvietntd@gmail.com'),
(5, 'nhưt', '0', 'nhut@gmail.com'),
(6, 'nhưt', '989223987', 'nhut@gmail.com'),
(7, 'nhut', '2147483647', 'quangvietntd@gmail.com'),
(8, 'nhut', '2147483647', 'quangvietntd@gmail.com'),
(9, 'nhut', '2147483647', 'quangvietntd@gmail.com'),
(10, 'nhut', '123', 'quangvietntd@gmail.com'),
(11, 'nhut', '2147483647', 'quangvietntd@gmail.com'),
(12, 'nhut', '123456789123', 'quangvietntd@gmail.com'),
(13, 'nhut', '0989223787', 'quangvietntd@gmail.com'),
(14, 'Anh', '123456', 'quangvietntd@gmail.com'),
(15, 'Việt Nam', '09895641', 'quangvietntd@gmail.com'),
(16, 'Anh tin', '4455761849', 'quangvietntd@gmail.com'),
(17, 'Anh tin', '09846', 'quangvietntd@gmail.com'),
(18, 'quang nhut', '08521470852', 'nhut@gmail.com'),
(19, 'Nguyen Quang Viet', '0984510852', 'quangvietntd@gmail.com'),
(20, 'Nguyen Quang Viet', '0984510852', 'quangvietntd@gmail.com');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loaisanpham`
--

CREATE TABLE `loaisanpham` (
  `id` int(11) NOT NULL,
  `tenloaisanpham` varchar(200) NOT NULL,
  `hinhanhloaisanpham` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `loaisanpham`
--

INSERT INTO `loaisanpham` (`id`, `tenloaisanpham`, `hinhanhloaisanpham`) VALUES
(1, 'Điện thoại', 'https://d30y9cdsu7xlg0.cloudfront.net/png/37361-200.png'),
(2, 'Laptop', 'https://cdn0.iconfinder.com/data/icons/future/512/notebook-512.png');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `id` int(11) NOT NULL,
  `tensanpham` varchar(200) NOT NULL,
  `giasanpham` int(15) NOT NULL,
  `hinhanhsanpham` varchar(200) NOT NULL,
  `motasanpham` varchar(10000) NOT NULL,
  `idsanpham` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`id`, `tensanpham`, `giasanpham`, `hinhanhsanpham`, `motasanpham`, `idsanpham`) VALUES
(1, 'Điện thoại iPhone X 256GB', 34790000, 'https://cdn.tgdd.vn/Products/Images/42/114111/iphone-x-256gb-h2-400x460.png', 'iPhone X được Apple ra mắt ngày 12/9 vừa rồi đánh dấu chặng đường 10 năm lần đầu tiên iPhone ra đời. Sau một thời gian, giá iPhone X cũng được công bố. iPhone X mang trên mình thiết kế hoàn toàn mới với màn hình Super Retina viền cực mỏng và trang bị nhiều công nghệ hiện đại như nhận diện khuôn mặt Face ID, sạc pin nhanh và sạc không dây cùng khả năng chống nước bụi cao cấp.', 1),
(2, 'Điện thoại ASUS Zenfone Max Plus M1 - ZB570TL', 5490000, 'https://cdn.tgdd.vn/Products/Images/42/139346/asus-zenfone-max-m1-plus-zb570tl-1-400x460.png', 'Zenfone Max Plus M1 là chiếc smartphone theo xu thế màn hình viền mỏng đầu tiên của ASUS. Với ưu điểm thiết kế đẹp, pin lớn truyền thống dòng Zenfone Max, camera kép và mức giá tầm trung cực kì hấp dẫn và đáng sở hữu.', 1),
(3, 'Điện thoại Xiaomi Redmi Note 5A (Redmi Y1 Lite)', 2990000, 'https://cdn.tgdd.vn/Products/Images/42/112972/xiaomi-redmi-note-5a-400x460.png', 'Xiaomi Redmi Note 5A là chiếc smartphone giá rẻ, có màn hình lớn sắc nét, chạy hệ điều hành Android 7.0 với giao diện MIUI 8 tuyệt đẹp và camera selfie nhiều chế độ làm đẹp hấp dẫn', 1),
(4, 'Điện thoại iPhone 8 Plus 256GB', 28790000, 'https://cdn.tgdd.vn/Products/Images/42/114114/iphone-8-plus-256gb2-400x460-1-400x460.png', 'iPhone 8 Plus là bản nâng cấp nhẹ của chiếc iPhone 7 Plus đã ra mắt trước đó với cấu hình mạnh mẽ cùng camera có nhiều cải tiến.', 1),
(5, 'Điện thoại Samsung Galaxy S9+ 64GB', 23490000, 'https://cdn.tgdd.vn/Products/Images/42/147939/samsung-galaxy-s9-plus-3-400x460.png', 'Samsung Galaxy S9 Plus, siêu phẩm smartphone hàng đầu trong thế giới Android đã ra mắt với màn hình vô cực, camera chuyên nghiệp như máy ảnh và hàng loạt những tính năng cao cấp đầy hấp dẫn.', 1),
(6, 'Điện thoại Sony Xperia XZ Premium Pink Gold', 14490000, 'https://cdn.tgdd.vn/Products/Images/42/113126/sony-xperia-xz-premium-pink-gold-400x460.png', 'Sony Xperia XZ Premium Pink Gold là một phiên bản khác của chiếc Sony Xperia XZ Premium với khác biệt duy nhất đến từ màu Pink Gold quyến rũ.', 1),
(7, 'Điện thoại OPPO F7 128GB', 9990000, 'https://cdn.tgdd.vn/Products/Images/42/158464/oppo-f7-128gb-den-400x460.png', 'Tiếp nối sự thành công của OPPO F5 thì OPPO tiếp tục giới thiệu OPPO F7 128GB với mức giá tương đương nhưng mang trong mình thiết kế hoàn toàn mới cũng nhiều cải tiến đáng giá.', 1),
(8, 'Điện thoại HTC U Ultra', 9890000, 'https://cdn.tgdd.vn/Products/Images/42/90772/htc-u-ultra-2-400x460.png', 'HTC U Ultra đánh dấu sự trở lại của HTC với triết lý thiết kế mới, đẹp hơn - sang trọng - bóng bẩy hơn và đặc biệt gắn bó với người dùng hơn thông qua trợ lý ảo HTC Sense Companion.', 1),
(9, 'Điện thoại Bphone 2017', 9790000, 'https://cdn.tgdd.vn/Products/Images/42/75001/bkav-bphone-2-hero-400x460.png', 'Bphone 2017 là chiếc smartphone thế hệ thứ 2 được nhà sản xuất Việt Nam Bkav trình làng với hàng loạt cải tiến vượt trội, tối ưu tốt nhất cho người Việt và giá bán rất tốt.', 1),
(10, 'Điện thoại OPPO F5 6GB', 8990000, 'https://cdn.tgdd.vn/Products/Images/42/142106/oppo-f5-6gb-a-2-400x460.png', 'OPPO F5 6GB là phiên bản nâng cấp cấu hình của chiếc OPPO F5, chuyên gia selfie làm đẹp thông minh và màn hình tràn viền tuyệt đẹp.', 1),
(11, 'Điện thoại Motorola Moto X4', 8990000, 'https://cdn.tgdd.vn/Products/Images/42/113327/motorola-moto-x4-den-400x460.png', 'Motorola Moto X4 là một chiếc smartphone tầm trung với điểm nhấn tới từ cụm camera kép ở mặt lưng.', 1),
(12, 'Điện thoại Nokia 7 plus', 8990000, 'https://cdn.tgdd.vn/Products/Images/42/153854/nokia-7-plus-5-400x460.png', 'Nokia 7 Plus là chiếc smartphone đầu tiên đánh dấu bước đi đầu tiên của HMD vào thế giới màn hình tỉ lệ 18:9.', 1),
(13, 'Điện thoại Vivo V9', 7990000, 'https://cdn.tgdd.vn/Products/Images/42/155047/vivo-v9-1-2-400x460-400x460.png', 'Vivo V9 là chiếc smartphone tầm trung cận cao cấp với điểm nhấn là máy có camera kép phía sau và camera selfie độ phân giải cao 24 MP.', 1),
(14, 'Điện thoại Sony Xperia XA1 Ultra', 7990000, 'https://cdn.tgdd.vn/Products/Images/42/92074/sony-xa1-ultra-trang-1-400x460.png', 'Kế nhiệm sự thành công của phablet không viền Sony Xperia XA Ultra thì Sony giới thiệu phiên bản XA1 Ultra với nhiều cải tiến đáng giá.', 1),
(15, 'Điện thoại Samsung Galaxy J7+', 7290000, 'https://cdn.tgdd.vn/Products/Images/42/112970/samsung-galaxy-j7-plus-1-400x460.png', 'Samsung Galaxy J7+ là dòng smartphone tầm trung nhưng được trang bị camera kép có khả năng chụp ảnh xóa phông chân dung cùng thiết kế đẹp và hiệu năng mạnh mẽ.', 1),
(16, 'Điện thoại Samsung Galaxy Note 8', 22490000, 'https://cdn.tgdd.vn/Products/Images/42/106211/samsung-galaxy-note8-1-400x460.png', 'Galaxy Note 8 là niềm hy vọng vực lại dòng Note danh tiếng của Samsung với diện mạo nam tính, sang trọng. Trang bị camera kép xóa phông thời thượng, màn hình vô cực như trên S8 Plus, bút Spen với nhiều tính năng mới và nhiều công nghệ được Samsung ưu ái đem lên Note 8.', 1),
(17, 'Điện thoại OPPO F3 Plus', 7490000, 'https://cdn.tgdd.vn/Products/Images/42/92569/oppo-f3-plus-1-1-400x460.png', 'Sau sự thành công của OPPO F1 Plus, OPPO F3 Plus đang được người dùng quan tâm yêu thích với cụm camera selfie kép, công nghệ chụp thiếu sáng đỉnh cao, cấu hình mạnh mẽ và tất nhiên đó là thiết kế nguyên khối quá ư là sang trọng.', 1),
(18, 'Điện thoại Huawei Nova 3e Hồng', 6990000, 'https://cdn.tgdd.vn/Products/Images/42/159569/huawei-nova-3e-hong-1-400x460.png', 'Là phiên bản nâng cấp của Nova 2i, Huawei Nova 3e hồng được thừa hưởng những xu hướng mới như màn hình tràn viền cùng tai thỏ thời thượng, cùng nhiều tính năng mới cao cấp.', 1),
(19, 'Điện thoại Xiaomi Mi A1 64GB', 5490000, 'https://cdn.tgdd.vn/Products/Images/42/113572/xiaomi-mi-a1-mau-vang-hong-400x460.png', 'Mi A1 được Xiaomi chính thức ra mắt tại Ấn Độ với vai trò là một dự án hợp tác Android One của Google. Hãy cùng mình trên tay nhanh chiếc máy chạy Android thuần cùng camera xóa phông ảo diệu mà giá chỉ hơn 5 triệu này nhé.', 1),
(22, 'Điện thoại Nokia 3', 2790000, 'https://cdn.tgdd.vn/Products/Images/42/91853/nokia-3-3-400x460.png', 'Thương hiệu Nokia vẫn rất được người dùng tin tưởng và đón chờ, năm nay hãng cũng đã đánh dấu sự trở lại với 3 mẫu điện thoại, Nokia 3 là một trong số đó.', 1),
(23, 'Laptop Asus S510UA i5 8250U/4GB/1TB/Win10/(BQ414T)', 16290000, 'https://cdn.tgdd.vn/Products/Images/44/135668/asus-s510ua-i5-8250u-bq414t-dai-dien-450x300.jpg', 'Laptop Asus S510UA i5 bản nâng cấp hết sức giá trị với chip xử lý thế hệ thứ 8 mới nhất của Intel cho hiệu năng vượt trội, đáp ứng tốt cho bạn trong các nhu cầu làm việc, học tập, giải trí hằng ngày.', 2),
(24, 'Laptop HP Pavilion x360 ba063TU i3 7100U/4GB/500GB/Win10/(2GV25PA)', 13490000, 'https://cdn.tgdd.vn/Products/Images/44/111137/hp-pavilion-x360-ba063tu-450x300-450x300.jpg', 'HP Pavilion x360 ba063TU i3 sở hữu cấu hình tầm trung, đáp ứng tốt các nhu cầu cơ bản với màn hình cảm ứng và xoay lật.', 2),
(25, 'Laptop Lenovo Yoga 520 14IKB i3 7130U/4GB/500GB/Win10/(80X80106VN)', 11990000, 'https://cdn.tgdd.vn/Products/Images/44/139279/lenovo-yoga-520-14ikb-i3-7130u-8080106vn-450x300.jpg', 'Máy tính xách tay Lenovo IdeaPad Yoga 520 là mẫu máy tính thuộc dòng phân khúc mỏng nhẹ của Lenovo. Máy có thiết kế hiện đại cùng một cấu hình thế hệ mới và với giá thành khá hợp lý, phù hợp với nhu cầu giải trí hay làm việc.', 2),
(26, 'Laptop Asus TP410UA i3 7100U/4GB/500GB/Win10/(EC250T)', 13990000, 'https://cdn.tgdd.vn/Products/Images/44/136220/asus-tp410ua-i3-7100u-ec250t-450-300-450x300.jpg', 'Asus TP410UA i3 7100U là một kiểu máy tính lai có thiết kế đẹp, tiện lợi và nhiều tính năng nổi trội cùng một mức giá vừa phải. Đây sẽ là sự lựa chọn rất tuyệt vời cho người dùng cần nhiều thao tác tích hợp trong một thiết bị nhỏ gọn.', 2),
(27, 'Laptop Lenovo IdeaPad 120S 11IAP N3350/2GB/32GB/Win10/(81A40072VN)', 5190000, 'https://cdn.tgdd.vn/Products/Images/44/113133/lenovo-ideapad-120s-11iap-450x300-1-450x300.jpg', 'enovo IdeaPad 120S 11IAP N3350 có cấu hình đủ dùng cho những ứng dụng cơ bản cùng mức giá bán hấp dẫn phủ hợp với những bạn học sinh sinh viên hay những người có thu nhập thấp muốn mua một chiếc laptop học tập, làm việc.', 2),
(28, 'Laptop Apple Macbook Air MQD32SA/A i5 1.8GHz/8GB/128GB (2017)', 20990000, 'https://cdn.tgdd.vn/Products/Images/44/106875/apple-macbook-air-mqd32sa-a-i5-5350u-400-1-450x300-450x300.jpg', 'Macbook Air MQD32SA/A i5 5350U với thiết kế vỏ nhôm nguyên khối Unibody rất đẹp, chắc chắn và sang trọng. Macbook Air là một chiếc laptop siêu mỏng nhẹ, hiệu năng ổn định mượt mà, thời lượng pin cực lâu, phục vụ tốt cho nhu cầu làm việc lẫn giải trí.', 2),
(29, 'Laptop Acer Aspire ES1 432 N3350/2GB/500GB/Win10', 6290000, 'https://cdn.tgdd.vn/Products/Images/44/146096/acer-aspire-es1-432-c3c9-n3350-nxgfssv005-450-300-450x300.png', 'Acer Aspire ES1 432 C3C9 N3350 là sản phẩm phổ thông với giá thành thấp, dễ tiếp cận đến người dùng. Máy có hiệu năng sử dụng đơn giản phù hợp để học tập, làm việc hay giải trí.', 2),
(30, 'Laptop Asus X441NA N4200/4GB/500GB/Win10/(GA070T)', 7490000, 'https://cdn.tgdd.vn/Products/Images/44/101829/asus-x441na-n4200-450x300.jpg', 'Asus X441NA N4200 là sự lựa chọn giá tốt phù hợp với học sinh - sinh viên hoặc người dùng làm việc văn phòng, giải trí nhẹ.', 2),
(31, 'Laptop Acer ES1 533 P6L2 N4200/4GB/500GB/Win10/(NX.GFTSV.008)', 7490000, 'https://cdn.tgdd.vn/Products/Images/44/120276/acer-es1-533-p6l2-n4200-nxgftsv00-dai-dien-fix-450x300.jpg', 'Acer ES1 533 P6L2 N4200 thuộc phân khúc học tập - văn phòng với giá tốt, được trang bị cấu hình vửa đủ sử dụng tính năng cơ bản và cài sẵn hệ điều hành windows 10 bản quyền giúp sử dụng ổn định, tiện lợi hơn.', 2),
(32, 'Laptop HP 15 bs641TU N3710/4GB/500GB/Win10/(3MT73PA)', 7690000, 'https://cdn.tgdd.vn/Products/Images/44/158019/hp-15-bs641tu-n3710-3mt73pa-450-300-600x600.jpg', 'Laptop HP 15 bs641TU N3710 là một chiếc máy tính xách tay phục vụ cho học tập, giải trí khá tốt. Máy được trang bị màn hình 15.6 inch cùng với cấu hình vừa phải đủ sức đáp ứng các nhu cầu cơ bản từ lướt web, xem phim, làm việc, học tập một cách mượt mà.', 2),
(33, 'Laptop Lenovo Ideapad 320 14ISK i3 6006/4GB/500GB/Win10/(80XG0083VN)', 8990000, 'https://cdn.tgdd.vn/Products/Images/44/146928/lenovo-ideapad-320-14isk-i3-6006-80xg0083vn-dai-dien-450x300.jpg', 'Một sản phẩm laptop thuộc phân khúc tầm trung bởi Lenovo Ideapad 320 14ISK chỉ sử dụng cấu hình Intel Core i3 và RAM 4 GB nhưng lại vận hành khá mượt mà. Chính vì vậy mà máy có giá thành dễ tiếp cận với nhiều khách hàng, đặc biệt phù hợp với học sinh - sinh viên và người dùng văn phòng - công sở.', 2),
(34, 'Laptop Acer Aspire E5 475 33WT i3 6006U/4GB/500GB/Win10/(NX.GCUSV.002)', 9490000, 'https://cdn.tgdd.vn/Products/Images/44/91406/acer-aspire-e5-475-33wt-i3-6006u-xam-avarta-450x300.jpg', 'Laptop Acer Aspire E5 475 33WT i3 6006U là sự lựa chọn đáng giá với cấu hình tốt so với nhiều đối thủ khác trong cùng phân khúc. Phù hợp với người dùng cần một chiếc laptop để học tập, làm việc.', 2),
(35, 'Laptop Lenovo IdeaPad 320 15IKBN i3 7130U/4GB/128GB/Win10/(80XL03SNVN)', 10490000, 'https://cdn.tgdd.vn/Products/Images/44/139349/lenovo-ideapad-320-15ikbn-i3-7130u-80xl03snvn-dai-dien-450x300.jpg', 'Lenovo IdeaPad 320 15IKBN i3 7130U là mẫu máy laptop tầm trung trang bị chip thế hệ Intel thế hệ 7 và màn hình Full HD đáng giá.', 2),
(36, 'Laptop Dell Vostro 3568 i3 7100U/4GB/1TB/Win10/(VTI3037W)', 12190000, 'https://cdn.tgdd.vn/Products/Images/44/93701/dell-vostro-3568-i3-7100u-den-avarta-10-450x300.jpg', 'Dell Vostro 3568 i3 7100U là sản phẩm có cấu hình tốt trong tầm giá, được trang bị chip xử lý thế hệ mới nhất, bảo mật vân tay cùng ổ cứng HDD lên đến 1 TB. Phù hợp với người dùng cần một chiếc máy laptop để học tập, làm việc, giải trí nhẹ nhàng.', 2),
(37, 'Laptop Dell Inspiron 3567 i3 6006U/4GB/1TB/2GB M430/Win10/(C5I3120W)', 12190000, 'https://cdn.tgdd.vn/Products/Images/44/91778/dell-inspiron-3567-i3-6006u-c5i3120w-den-2-450x300-450x300-450x300.jpg', 'Dell Inspiron 3567 i3 6006U là phiên bản nâng cấp với RAM 4 GB cùng card màn hình rời AMD là chiếc laptop thích hợp dành cho việc giải trí. Phù hợp với người dùng cần một chiếc laptop để học tập, giải trí nhẹ nhàng.', 2),
(38, 'Laptop Acer Swift SF314 32EX i3 7100U/4GB/128GB/Win10/(NX.GKKSV.006)', 14990000, 'https://cdn.tgdd.vn/Products/Images/44/91985/acer-swift-sf314-32ex-i3-7100u-dai-dien-450x300.jpg', 'Laptop Acer Swift SF314 32EX là một sản phẩm có thiết kế sang trọng với vỏ kim loại chắc chắn, bảo mật vân tay, cùng màn hình Full HD sắc nét. Máy phù hợp với người dùng cần một chiếc laptop mỏng nhẹ, truy xuất dữ liệu nhanh', 2),
(39, 'Laptop HP Envy 13 ad160TU i7 8550U/8GB/256GB/Win10/(3MR77PA)', 26490000, 'https://cdn.tgdd.vn/Products/Images/44/155312/hp-envy-13-ad160tu-i7-8550u-3mr77pa-450-600x600.jpg', 'Laptop HP Envy 13 ad160TU (3MR77PA) xứng đáng là ông hoàng laptop trong phân khúc mỏng nhẹ - thời trang vì những ưu điểm nổi bậc về thiết kế và cấu hình mạnh mẽ của sản phẩm.', 2),
(40, 'Laptop Apple Macbook Pro Touch MPTR2SA/A i7 2.8GHz/16GB/256GB (2017)', 59990000, 'https://cdn.tgdd.vn/Products/Images/44/158072/apple-macbook-pro-touch-mptr2sa-a-i7-28ghz-2017-450-3002-600x600.jpg', 'Nếu nhắc đến các siêu phẩm máy tính xách tay thì không thể bỏ qua được cái tên Apple - Macbook. Đặc biệt các sản phẩm thuộc dòng Pro như Macbook Pro Touch MPTR2SA/A i7 thì càng rất được nhiều người dùng quan tâm đến một chiếc laptop làm đồ hoạ tốt, làm việc mượt mà.', 2),
(41, 'Laptop Dell Vostro 3568 i5 7200U/4GB/1TB/Win10/(XF6C611)', 14690000, 'https://cdn.tgdd.vn/Products/Images/44/103630/dell-vostro-3568-i5-7200u-400-450x300-450x300.png', 'Dell Vostro 3568 i5 7200U được trang bị chip xử lý thế hệ mới thứ 7, bảo mật vân tay, màn hình lớn cùng ổ cứng HDD lên đến 1 TB.', 2),
(42, 'Laptop HP Envy 13 ad158TU i5 8250U/4GB/128GB/Win10/(3MR80PA)', 19990000, 'https://cdn.tgdd.vn/Products/Images/44/155306/hp-envy-13-ad158tu-i5-8250u-3mr80pa-450-600x600.jpg', 'Laptop HP Envy 13 ad158TU (3MR80PA) đáp ứng được hầu hết các nhu cầu hiện đại của người dùng cần một chiếc laptop mỏng nhẹ dễ di chuyển, cấu hình mạnh - ổn định và rất tiết kiệm điện năng.', 2);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chitietdonhang`
--
ALTER TABLE `chitietdonhang`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `donhang`
--
ALTER TABLE `donhang`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `loaisanpham`
--
ALTER TABLE `loaisanpham`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `chitietdonhang`
--
ALTER TABLE `chitietdonhang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `donhang`
--
ALTER TABLE `donhang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT cho bảng `loaisanpham`
--
ALTER TABLE `loaisanpham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
