# Settlers

This is my pet project - I'm making a PC version of the boardgame The Settlers of Catan.

I used the Model View Controller approach. I made a GUI and a map drawn during the game. Git and multithreading were used as well.


This is what the boardgame map looks like:

![Settlers middlegame](https://user-images.githubusercontent.com/56831898/191044980-feb18537-ab89-4205-ae07-a6e9397a7c39.png)

The map is made of hexes. Each one has a number. Every turn two 6-sided dice are rolled, and their combined result determines which hexes are active that turn.

Each turn players with settlements near active hexes get resources. 
On their turn, players can use the cursor to build towns, cities and roads. This costs resources.

![Building roads and a settlement](https://user-images.githubusercontent.com/56831898/194759545-421f0d5c-d963-46a2-8811-795105f0296f.gif)

Sometimes, based on the dice roll, instead of getting resources, players with more than 7 combined resources have to discard a half of their "wealth" in this window:

![Discarding window](https://user-images.githubusercontent.com/56831898/194758606-466a7e56-8418-4b91-8549-a124c6e23fa7.gif)

After that, the active players chooses a hex that will have a Robber on it and so will not provide any resources.

As the player hovers the cursor over a hex, it is hilighted:

![Moving the Robber](https://user-images.githubusercontent.com/56831898/194759142-769b924a-6158-4e59-a098-2103a797ebbe.gif)

---

Мой любительский проект - делаю компьютерную версию настольной игры Колонизаторы. 

В ходе разработки использовал подход Model View Controller. 
Сделал графический интерфейс и отрисовываемую по ходу игры карту. 
Использовал Git, использовал многопоточность.

Так выглядит поле игры. 

![Settlers middlegame](https://user-images.githubusercontent.com/56831898/191044980-feb18537-ab89-4205-ae07-a6e9397a7c39.png)

Во время своего хода можно курсором строить города, поселения и дороги, если на это хватает ресурсов. 

![Building roads and a settlement](https://user-images.githubusercontent.com/56831898/194759545-421f0d5c-d963-46a2-8811-795105f0296f.gif)

Каждый ход бросается два кубика, и по результату броска все игроки, имеющие поселения/города, прилегающие к соответствующим шестиугольникам на карте, получают ресурсы. 

Когда на кубиках выпадает 7, игроки со слишком большим количеством ресурсов должны сбросить половину в специальном окне:

![Discarding window](https://user-images.githubusercontent.com/56831898/194758606-466a7e56-8418-4b91-8549-a124c6e23fa7.gif)

Далее активный игрок выбирает шестиугольник, на котором будет разбойник. Во время выбора шестиугольники подсвечиваются розовым, когда над ними курсор.

![Moving the Robber](https://user-images.githubusercontent.com/56831898/194759142-769b924a-6158-4e59-a098-2103a797ebbe.gif)
