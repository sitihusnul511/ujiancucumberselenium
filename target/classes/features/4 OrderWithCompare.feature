Feature: Customer Order with Seach
	Scenario: Testing Search Order
		When Customer kembali ke halaman product
		Then Customer memilih product
		And Customer memilih product kedua
		Then Customer checkout product
		Then Customer berhasil order kedua