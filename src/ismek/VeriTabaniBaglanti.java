package ismek;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class VeriTabaniBaglanti {
	private static Connection con = null;

	public VeriTabaniBaglanti() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver bulunamadý");
		}
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/siparis?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey",
					"root", "12345");
			System.out.println("Baðlantý baþarýlý");
		} catch (SQLException e) {
			System.out.println("Baðlantý baþarýsýz");
			e.printStackTrace();
		}

	}

	public static void müsterilistele() {
		try {
			VeriTabaniBaglanti vt = new VeriTabaniBaglanti();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from musteri");
			MusteriFirma mf = new MusteriFirma();

			Ayrac.ayracyazdir();

			while (rs.next())

				System.out.println(rs.getInt(1) + "--" + rs.getString(2));

		} catch (Exception e) {
			System.out.println(e);
		}

		finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("baðlantý kapanmadý");
			}
		}
	}

	public static void musteriekle() {

		Scanner scanner = new Scanner(System.in);
		MusteriFirma musteri = new MusteriFirma();
		ÝletisimBilgisi iletisimBilgisi = new ÝletisimBilgisi();

		Ayrac.ayracyazdir();
		System.out.println("------------müþteri bilgilerini giriniz----------");
		Ayrac.ayracyazdir();

		
		System.out.println("Id:");
		int musteriId = scanner.nextInt();
		musteri.setId(musteriId);
		Ayrac.ayracyazdir();
		
		System.out.println("Müþteri adý:");
		String musteriAd = scanner.next();
		musteri.setAdi(musteriAd);
		Ayrac.ayracyazdir();

		System.out.println("Telefon:");
		int telefon = scanner.nextInt();
		iletisimBilgisi.setTelefon(telefon);
		Ayrac.ayracyazdir();

		System.out.println("Email:");
		String email = scanner.next();
		iletisimBilgisi.setEmail(email);
		Ayrac.ayracyazdir();

		System.out.println("Gönderi adresi:");
		String gonderiAdresi = scanner.nextLine();
		iletisimBilgisi.setGonderiAdresi(gonderiAdresi);
		Ayrac.ayracyazdir();

		System.out.println("Fatura Adresi");
		String faturaAdresi = scanner.nextLine();
		iletisimBilgisi.setFaturaAdresi(faturaAdresi);
		Ayrac.ayracyazdir();

		try {
			VeriTabaniBaglanti vt = new VeriTabaniBaglanti();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from musteri");
			String sorgu1 = "insert into musteri(kod,ad) values (?,?)";

			PreparedStatement prepareStatement1 = con.prepareStatement(sorgu1);
			prepareStatement1.setInt(1, musteri.getid());
			prepareStatement1.setString(2, musteri.getAdi());

			prepareStatement1.execute();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("baðlantý kapanmadý");
			}
		}
		try {
			VeriTabaniBaglanti vt = new VeriTabaniBaglanti();
			Statement stmt = con.createStatement();
			ResultSet ss = stmt.executeQuery("select * from iletisimbilgisi");

			String sorgu2 = "insert into iletisimbilgisi(telefon,email,gonderiAdresi,faturaAdresi) values (?,?,?,?)";
			PreparedStatement prepareStatement2 = con.prepareStatement(sorgu2);
			prepareStatement2.setInt(1, iletisimBilgisi.getTelefon());
			prepareStatement2.setString(2, iletisimBilgisi.getEmail());
			prepareStatement2.setString(3, iletisimBilgisi.getGonderiAdresi());
			prepareStatement2.setString(4, iletisimBilgisi.getFaturaAdresi());

			prepareStatement2.execute();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("baðlantý kapanmadý");
			}
		}
	}

	public static void kumasekle() {

		Scanner scanner = new Scanner(System.in);
		KumasBilgisi kumas = new KumasBilgisi();

		Ayrac.ayracyazdir();
		System.out.println("------------Kumaþ bilgilerini giriniz----------");
		Ayrac.ayracyazdir();

		System.out.println("kod:");
		String kod = scanner.next();
		kumas.setKod(kod);
		Ayrac.ayracyazdir();

		System.out.println("Birim fiyat:");
		Float birimFiyat = scanner.nextFloat();
		kumas.setBirimFiyat(birimFiyat);
		Ayrac.ayracyazdir();

		System.out.println("Ýplik çeþidi:");
		String iplikCesidi = scanner.next();
		kumas.setIplikCesidi(iplikCesidi);
		Ayrac.ayracyazdir();

		System.out.println("Renk:");
		String renk = scanner.next();
		kumas.setRenk(renk);
		Ayrac.ayracyazdir();

		try {

			VeriTabaniBaglanti vt = new VeriTabaniBaglanti();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from kumas");
			String sorgu = "insert into kumas(kod,birimFiyat,iplikCesidi,renk) values (?,?,?,?)";

			PreparedStatement prepareStatement = con.prepareStatement(sorgu);
			prepareStatement.setString(1, kumas.getKod());
			prepareStatement.setFloat(2, kumas.getBirimFiyat());
			prepareStatement.setString(3, kumas.getIplikCesidi());
			prepareStatement.setString(4, kumas.getRenk());

			System.out.println("Kumaþ Eklendi");
			prepareStatement.execute();

		} catch (SQLException e) {

			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("baðlantý kapanmadý");
			}

		}

	}

	public static void kumaslistele() {
		try {
			VeriTabaniBaglanti vt = new VeriTabaniBaglanti();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from kumas");
			MusteriFirma mf = new MusteriFirma();

			Ayrac.ayracyazdir();
			while (rs.next())

				System.out.println(rs.getString(1) + "-----" + rs.getFloat(2) + "-----" + rs.getString(3) + "-----"
						+ rs.getString(4) + "-----" + rs.getInt(5));

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("baðlantý kapanmadý");
			}
		}

	}
}
