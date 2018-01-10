class RetailItem:

    def __init__(self, description, unit, price):
        self.description = description
        self.unit = unit
        self.price = price


class CashRegister:
    lst = []

    def purchase_item(self, retailItem):
        self.lst.append(retailItem)

    def get_total(self):
        total_price = 0
        if self.lst is None:
            return 0
        for i in self.lst:
            total_price += (i.price * i.unit)

        return total_price

    def show_items(self):
        if self.lst is None:
            print("You didn't purchase any product")
            return
        for i in self.lst:
            print("item", (self.lst.index(i) + 1), ": Description --> ", i.description,
                  ", Units --> ", i.unit, " Price --> ", i.price)

    def clear(self):
        self.lst = None


retailItem1 = RetailItem("Jacket", 12, 59.95)
retailItem2 = RetailItem("Designer", 40, 34.95)
retailItem3 = RetailItem("Shirt", 20, 24.95)

cashRegister = CashRegister()
cashRegister.purchase_item(retailItem1)
cashRegister.purchase_item(retailItem2)
cashRegister.purchase_item(retailItem3)

cashRegister.show_items()

print("The total price is: ", cashRegister.get_total())

cashRegister.clear()

cashRegister.show_items()
