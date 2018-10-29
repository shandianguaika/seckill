-- 数据库初始化脚本

-- 创建数据库
CREATE database seckill;
-- 使用数据库
use seckill;
create table seckill(
seckill_id varchar(50) not null comment '商品库存id',
name varchar(120) comment '商品名称',
number int comment '库存数量',
start_time timestamp comment '秒杀开启时间',
end_time timestamp comment '秒杀结束时间',
create_time timestamp comment '创建时间',
create_by varchar(50) comment '创建人',
primary key (seckill_id),
key idx_start_time(start_time)
)engine=InnoDB default charset=utf8 comment='秒杀库存表';

-- 初始化数据
insert into seckill(seckill_id,name,number,start_time,end_time,create_time,create_by)
values(1000,'1000元秒杀iPhoneX',10,'2018-10-24 00:00:00','2018-10-24 23:00:00','2018-10-24 00:00:00','马云'),
(1001,'500元秒杀iPad2',30,'2018-10-24 00:00:00','2018-10-24 23:00:00','2018-10-24 00:00:00','马云'),
(1002,'300元秒杀小米4',40,'2018-10-25 00:00:00','2018-10-25 23:00:00','2018-10-24 00:00:00','马云'),
(1003,'200元秒杀红米note',50,'2018-10-25 00:00:00','2018-10-25 23:00:00','2018-10-24 00:00:00','马云'),
(1004,'10元秒杀饮水机',100,'2018-10-26 00:00:00','2018-10-26 23:00:00','2018-10-24 00:00:00','马云')
;

-- 秒杀成功明细表
-- 用户登录认证相关的信息
create table success_killed(
seckill_id varchar(50) not null comment '秒杀商品id',
user_phone varchar(20) not null comment '用户手机号',
state tinyint not null default -1 comment '状态标识：-1 无效，0秒杀成功，1 已付款',
create_time timestamp comment '创建时间',
primary key(seckill_id,user_phone), -- 联合主键
key idx_create_time (create_time)
)engine = InnoDB default charset = utf8 comment '秒杀成功明细表';


