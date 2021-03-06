USE [KyNghe]
GO
/****** Object:  Database [KyNghe]    Script Date: 4/10/2019 1:33:00 PM ******/
CREATE DATABASE [KyNghe]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'KyNghe', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\KyNghe.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'KyNghe_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\KyNghe_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [KyNghe] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [KyNghe].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [KyNghe] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [KyNghe] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [KyNghe] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [KyNghe] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [KyNghe] SET ARITHABORT OFF 
GO
ALTER DATABASE [KyNghe] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [KyNghe] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [KyNghe] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [KyNghe] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [KyNghe] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [KyNghe] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [KyNghe] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [KyNghe] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [KyNghe] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [KyNghe] SET  DISABLE_BROKER 
GO
ALTER DATABASE [KyNghe] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [KyNghe] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [KyNghe] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [KyNghe] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [KyNghe] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [KyNghe] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [KyNghe] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [KyNghe] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [KyNghe] SET  MULTI_USER 
GO
ALTER DATABASE [KyNghe] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [KyNghe] SET DB_CHAINING OFF 
GO
ALTER DATABASE [KyNghe] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [KyNghe] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [KyNghe] SET DELAYED_DURABILITY = DISABLED 
GO
USE [KyNghe]
GO
/****** Object:  Table [dbo].[DuAn]    Script Date: 4/10/2019 1:33:00 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DuAn](
	[MaDuAn] [nvarchar](50) NOT NULL,
	[TenDuAn] [nvarchar](50) NULL,
	[NgayBatDau] [date] NULL,
	[NgayKetThuc] [date] NULL,
	[TinhTrang] [nvarchar](50) NULL,
 CONSTRAINT [PK_DuAn] PRIMARY KEY CLUSTERED 
(
	[MaDuAn] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[KyNang]    Script Date: 4/10/2019 1:33:00 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KyNang](
	[MaKyNang] [nvarchar](50) NOT NULL,
	[TenKyNang] [nvarchar](50) NULL,
	[MoTa] [nvarchar](50) NULL,
 CONSTRAINT [PK_KyNang] PRIMARY KEY CLUSTERED 
(
	[MaKyNang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[KyNangNhanVien]    Script Date: 4/10/2019 1:33:00 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KyNangNhanVien](
	[MaNV] [nvarchar](50) NOT NULL,
	[MaKyNang] [nvarchar](50) NOT NULL,
	[MoTaKhac] [nvarchar](50) NULL,
 CONSTRAINT [PK_KyNangNhanVien] PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC,
	[MaKyNang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Login]    Script Date: 4/10/2019 1:33:00 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Login](
	[username] [nvarchar](50) NOT NULL,
	[password] [nvarchar](50) NULL,
 CONSTRAINT [PK_Login] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 4/10/2019 1:33:00 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNV] [nvarchar](50) NOT NULL,
	[Ten] [nvarchar](50) NULL,
	[NgaySinh] [date] NULL,
	[DiaChi] [nvarchar](50) NULL,
	[Sdt] [nvarchar](50) NULL,
	[Email] [nvarchar](50) NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PhanCong]    Script Date: 4/10/2019 1:33:00 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhanCong](
	[MaPhanCong] [nvarchar](50) NOT NULL,
	[MaNV] [nvarchar](50) NULL,
	[MaDuAn] [nvarchar](50) NULL,
	[NgayBatDau] [date] NOT NULL,
	[NgayKetThuc] [date] NULL,
	[SoNgayDaLamViec] [nvarchar](50) NULL,
	[TienDoHoanThanh] [nvarchar](50) NULL,
 CONSTRAINT [PK_PhanCong] PRIMARY KEY CLUSTERED 
(
	[MaPhanCong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[DuAn] ([MaDuAn], [TenDuAn], [NgayBatDau], [NgayKetThuc], [TinhTrang]) VALUES (N'PJ01', N'App hẹn hò', CAST(N'2019-01-01' AS Date), CAST(N'2019-01-06' AS Date), N'Chưa hoàn thành')
INSERT [dbo].[DuAn] ([MaDuAn], [TenDuAn], [NgayBatDau], [NgayKetThuc], [TinhTrang]) VALUES (N'PJ02', N'Web bán hàng', CAST(N'2019-01-07' AS Date), CAST(N'2019-01-10' AS Date), N'Chưa hoàn thành')
INSERT [dbo].[DuAn] ([MaDuAn], [TenDuAn], [NgayBatDau], [NgayKetThuc], [TinhTrang]) VALUES (N'PJ03', N'Web thông tin chính phủ', CAST(N'2018-01-01' AS Date), CAST(N'2018-01-06' AS Date), N'Hoàn thành')
INSERT [dbo].[DuAn] ([MaDuAn], [TenDuAn], [NgayBatDau], [NgayKetThuc], [TinhTrang]) VALUES (N'PJ04', N'Game bắn trứng', CAST(N'2018-01-07' AS Date), CAST(N'2018-01-07' AS Date), N'Hoàn thành')
INSERT [dbo].[DuAn] ([MaDuAn], [TenDuAn], [NgayBatDau], [NgayKetThuc], [TinhTrang]) VALUES (N'PJ05', N'App bản đồ', CAST(N'2020-01-01' AS Date), CAST(N'2020-01-06' AS Date), N'Chưa hoàn thành')
INSERT [dbo].[KyNang] ([MaKyNang], [TenKyNang], [MoTa]) VALUES (N'KN01', N'C#', N'Ngôn ngữ C #')
INSERT [dbo].[KyNang] ([MaKyNang], [TenKyNang], [MoTa]) VALUES (N'KN02', N'Java', N'Ngôn ngữ Java')
INSERT [dbo].[KyNang] ([MaKyNang], [TenKyNang], [MoTa]) VALUES (N'KN03', N'C', N'Ngôn ngữ đồ cổ')
INSERT [dbo].[KyNang] ([MaKyNang], [TenKyNang], [MoTa]) VALUES (N'KN04', N'F#', N'Ngôn ngữ khoa học')
INSERT [dbo].[KyNang] ([MaKyNang], [TenKyNang], [MoTa]) VALUES (N'KN05', N'Pascal', N'Ngôn ngữ câp 3')
INSERT [dbo].[KyNangNhanVien] ([MaNV], [MaKyNang], [MoTaKhac]) VALUES (N'NV01', N'KN02', N'Có kinh nghiệm')
INSERT [dbo].[KyNangNhanVien] ([MaNV], [MaKyNang], [MoTaKhac]) VALUES (N'NV02', N'KN01', N'Nhân viên có năng lực')
INSERT [dbo].[KyNangNhanVien] ([MaNV], [MaKyNang], [MoTaKhac]) VALUES (N'NV03', N'KN04', N'Cần học hỏi')
INSERT [dbo].[KyNangNhanVien] ([MaNV], [MaKyNang], [MoTaKhac]) VALUES (N'NV04', N'KN05', N'Cần luyện tập')
INSERT [dbo].[KyNangNhanVien] ([MaNV], [MaKyNang], [MoTaKhac]) VALUES (N'NV05', N'KN03', N'Nhân viên mới')
INSERT [dbo].[Login] ([username], [password]) VALUES (N'thang', N'123')
INSERT [dbo].[NhanVien] ([MaNV], [Ten], [NgaySinh], [DiaChi], [Sdt], [Email]) VALUES (N'NV01', N'Nguyễn Ánh', CAST(N'2000-01-27' AS Date), N'Huế', N'123456', N'anh123@gmail.com')
INSERT [dbo].[NhanVien] ([MaNV], [Ten], [NgaySinh], [DiaChi], [Sdt], [Email]) VALUES (N'NV02', N'Nguyễn Thành', CAST(N'1992-01-01' AS Date), N'Hà Nội', N'456123', N'thanh123@gmail.com')
INSERT [dbo].[NhanVien] ([MaNV], [Ten], [NgaySinh], [DiaChi], [Sdt], [Email]) VALUES (N'NV03', N'Phan Hưng', CAST(N'1993-05-02' AS Date), N'Đà nẵng', N'678421', N'hung456@gmail.com')
INSERT [dbo].[NhanVien] ([MaNV], [Ten], [NgaySinh], [DiaChi], [Sdt], [Email]) VALUES (N'NV04', N'Phạm Minh', CAST(N'1995-03-15' AS Date), N'Huế', N'623683', N'minh789@yahoo.com')
INSERT [dbo].[NhanVien] ([MaNV], [Ten], [NgaySinh], [DiaChi], [Sdt], [Email]) VALUES (N'NV05', N'Dương Đức', CAST(N'1998-06-04' AS Date), N'HCM', N'234863', N'duc478@yahoo.com')
INSERT [dbo].[PhanCong] ([MaPhanCong], [MaNV], [MaDuAn], [NgayBatDau], [NgayKetThuc], [SoNgayDaLamViec], [TienDoHoanThanh]) VALUES (N'PC01', N'NV01', N'PJ01', CAST(N'2019-01-01' AS Date), CAST(N'2019-01-02' AS Date), N'1', N'Chua hoàn thành')
ALTER TABLE [dbo].[KyNangNhanVien]  WITH CHECK ADD  CONSTRAINT [FK_KyNangNhanVien_KyNang] FOREIGN KEY([MaKyNang])
REFERENCES [dbo].[KyNang] ([MaKyNang])
GO
ALTER TABLE [dbo].[KyNangNhanVien] CHECK CONSTRAINT [FK_KyNangNhanVien_KyNang]
GO
ALTER TABLE [dbo].[KyNangNhanVien]  WITH CHECK ADD  CONSTRAINT [FK_KyNangNhanVien_NhanVien] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[KyNangNhanVien] CHECK CONSTRAINT [FK_KyNangNhanVien_NhanVien]
GO
ALTER TABLE [dbo].[PhanCong]  WITH CHECK ADD  CONSTRAINT [FK_PhanCong_DuAn] FOREIGN KEY([MaDuAn])
REFERENCES [dbo].[DuAn] ([MaDuAn])
GO
ALTER TABLE [dbo].[PhanCong] CHECK CONSTRAINT [FK_PhanCong_DuAn]
GO
ALTER TABLE [dbo].[PhanCong]  WITH CHECK ADD  CONSTRAINT [FK_PhanCong_NhanVien] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[PhanCong] CHECK CONSTRAINT [FK_PhanCong_NhanVien]
GO
USE [master]
GO
ALTER DATABASE [KyNghe] SET  READ_WRITE 
GO
