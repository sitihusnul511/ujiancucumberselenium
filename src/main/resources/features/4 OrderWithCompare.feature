Feature: Customer Order with Seach
	Scenario: Testing Search Order
		When Customer kembali ke halaman utama
		When Customer memilih product
		And Customer memilih product kedua
		And Customer checkout product
		Then Customer berhasil order kedua