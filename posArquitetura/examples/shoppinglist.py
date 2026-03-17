shoppingList = ["milk", "eggs", "bread", "butter"]
product = input("Enter a product to verify in the shopping list: ")

if product in shoppingList:
  print(f"{product} is in the shopping list.")
else:
  print(f"{product} is not in the shopping list.")
