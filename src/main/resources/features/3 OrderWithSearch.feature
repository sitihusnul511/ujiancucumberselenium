Feature: Customer Order with Search
	Scenario: Testing Search Order
		When Customer masuk halaman product
		Then Customer mencari product
		And Customer melakukan checkout
		Then Customer berhasil order