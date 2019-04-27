package ismek;

import java.util.Scanner;

public class MusteriİcinSiparisVerme {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		boolean dongu = true;
		do {

			MenuUtils.menuYazdır();
			System.out.print("Seçiminiz:");
			int secim = scanner.nextInt();
			switch (secim) {
			case 1:
				VeriTabaniBaglanti.musteriekle();
				Ayrac.ayracyazdir();

				break;
			case 2:
				VeriTabaniBaglanti.müsterilistele();
				Ayrac.ayracyazdir();

				break;
			case 3:

				VeriTabaniBaglanti.kumasekle();
				Ayrac.ayracyazdir();
		
				break;
			case 4:
				VeriTabaniBaglanti.kumaslistele();
				Ayrac.ayracyazdir();
			case 5:
				dongu = false;
				break;

			default:
				System.out.println("sistemden çıkıldı");
				break;
			}
		} while (dongu);
	}

}
