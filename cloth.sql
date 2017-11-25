--服装供应厂商表
create table supplier(
	supid int primary key auto_increment,  --供应商编号
	supname varchar(100) not null,         --供应厂商名
	supaddress varchar(200) not null,      --供应厂商地址
	supcontacts varchar(100) not null,     --供应厂商联系人姓名
	suptel varchar(11) not null,           --供应厂商联系人电话
	supemail varchar(100)                  --供应厂商联系人邮箱
)ENGINE=InnoDB default charset=utf8 collate=utf8_bin;
alter table supplier auto_increment=1001;

--角色表
create table roles(
	rolid int primary key auto_increment,    --角色编号
	rolname varchar(100) not null,           --角色名
)ENGINE=InnoDB default charset=utf8 collate=utf8_bin;
alter table roles auto_increment=1001;

--员工表
create table staff(
	staid int primary key auto_increment,    --员工编号
	staname varchar(100) not null,           --员工姓名
	stapwd varchar(100) not null,            --员工密码
	stasex varchar(2) not null,              --员工性别
	staage varchar(10) not null,             --员工年龄 
	statel varchar(11) not null,             --员工联系电话
	staphoto blob not null,                  --员工照片
	rolid int,                               --角色编号
	constraint FK_staff_rolid foreign key(rolid) references roles(rolid)
)ENGINE=InnoDB default charset=utf8 collate=utf8_bin;
alter table staff auto_increment=1001;

--客户表
create table client(
	cliid int primary key auto_increment,  --客户编号
	cliname varchar(100) not null,         --客户姓名
	clipwd varchar(100) not null,  		   --客户密码
	clitel varchar(11) not null,           --客户电话
	cliaddr varchar(100) not null          --客户地址
)ENGINE=InnoDB default charset=utf8 collate=utf8_bin;
alter table client auto_increment=1001;

--服装款式表
create table style(
	styid int primary key auto_increment,   --款式编号
	styname varchar(100) not null,          --款式名称
)ENGINE=InnoDB default charset=utf8 collate=utf8_bin;
alter table style auto_increment=1001;

--服装大类表
create table goods(
	gooid int primary key auto_increment,   --服装大类编号
	gooname varchar(100) not null,   		--服装大类名称
	styid int,                       		--服装大类款式
	gooprice double not null,         		--服装类售价
	constraint FK_goods_styid foreign key(styid) references style(styid)
)ENGINE=InnoDB default charset=utf8 collate=utf8_bin;
alter table goods auto_increment=1001;

--同颜色同尺寸服装表
create table goodsdetails(
	gooid int,						   --服装大类编号
	goodid varchar(100) primary key,   --服装条形码编号
	goodcolor varchar(100) not null,   --服装颜色
	goodsize varchar(100) not null,    --服装尺寸
	goodpic blob not null,             --服装图片
	goodstatus varchar(20) not null,   --服装状态
	goodinventory int not null,        --服装库存量
	constraint FK_goodsdetails_gooid foreign key(gooid) references goods(gooid)
)ENGINE=InnoDB default charset=utf8 collate=utf8_bin;

--订单表
create table orders(
	ordid varchar(100) primary key,   --订单编号
	cliid int,						  --客户编号
	ordtime date not null,            --下单时间
	ordprice double not null,         --订单总金额
	constraint FK_orders_cliid foreign key(cliid) references client(cliid)
)ENGINE=InnoDB default charset=utf8 collate=utf8_bin;

--订单详细表
create table ordersdetailed(
	ordid varchar(100),                      --订单编号
	orddid int primary key auto_increment,   --订单详细编号
	goodid varchar(100) not null,     		 --服装条形码编号
	orddnum int not null,               	 --购买数量
	orddprice double not null,         		 --单件服装价格
	constraint FK_ordersdetailed_ordid foreign key(ordid) references orders(ordid),
	constraint FK_ordersdetailed_gooid foreign key(goodid) references goodsdetails(goodid)
)ENGINE=InnoDB default charset=utf8 collate=utf8_bin;
alter table ordersdetailed auto_increment=1001;

--进货表
create table purchase(
	purid int primary key auto_increment,   --进货编号
	staid int,   							--员工编号
	supid int,								--供应商编号
	purtime date not null,                  --进货时间
	purprice double not null,               --总价钱
	constraint FK_purchase_staid foreign key(staid) references staff(staid),
	constraint FK_purchase_supid foreign key(supid) references supplier(supid)
)ENGINE=InnoDB default charset=utf8 collate=utf8_bin;
alter table purchase auto_increment=1001;

--进货详细表
create table purchasedetailed(
	purid int,								 --进货编号
	purcid int primary key auto_increment,   --进货详细编号
	gooid varchar(100) not null, 			 --服装条形码编号
	purcprice double not null,				 --单件进货价格
	purcnum int not null,					 --进货数量
	constraint FK_purchasedetailed_purid foreign key(purid) references purchase(purid)
)ENGINE=InnoDB default charset=utf8 collate=utf8_bin;
alter table purchasedetailed auto_increment=1001;
