Feature: Navigate through menu Groceries

  Rule: navigation through menu Groceries is possible (chosen menu buttons are clickable)

    Scenario Outline: navigate through menu
      Given I open tesco online shop
      And the list of categories of Groceries is present
      When I press <button_name_first>
      And I press next <button_name_second>
      And I press next <button_name_third>
      Then the header of the page is <header_of_page>

      Examples:
        | button_name_first | button_name_second    | button_name_third	        |	header_of_page 		      |
        | BBQ			    | Bakery        	    | Fresh and prepacked Bakery|	Fresh and prepacked Bakery|
        | Fruit & Vegetables| Salads	      	    | Ready to Cook Vegetables  |	Ready to Cook Vegetables  |
