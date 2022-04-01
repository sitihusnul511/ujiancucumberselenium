Feature: Customer Order with Seach
	Scenario: Testing Search Order
		When Customer masuk halaman product
		Then Customer mencari product
		And Customer melakukan checkout
		Then Customer berhasil order