# Caixa Econômica Federal

Bank code: `104`

## Calculating the account check digit

The Caixa Econômica Federal account number is composed by two things:
 - An 'operation', with 3 digits
 - The account number, with 8 digits.

Valid operation numbers:

| Operation | Meaning                   |
| --------- | ------------------------- |
| `001`     | Personal checking account |
| `002`     | Personal simple account   |
| `003`     | Company checking account  |
| `006`     | Public entities           |
| `007`     | Financial institutions    |
| `013`     | Personal savings account  |
| `022`     | Company savings account   |
| `028`     | Real state credit savings |
| `043`     | Lottery deposits          |

Weight: `8, 7, 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2`

1. Concatenate the agency number, the operation number and the account number
2. Multiply each number by the correct weight
3. Sum the results
4. Multiply by `10`
5. Get the mod of the multiplication by `11`
6. If the result is `10`, the check digit is `0`. Otherwise, the check digit is the result.

Example:

Agency number: `1234`  
Operation number: `001`  
Account number: `12345678`

1. Concatenate the agency number, the operation number and the account number  
`123400112345678`

2. Multiply each number by the correct weight

<table>
  <tr>
    <td></th>
    <td>1</th>
    <td>2</th>
    <td>3</th>
    <td>4</th>
    <td>0</th>
    <td>0</th>
    <td>1</th>
    <td>1</th>
    <td>2</th>
    <td>3</th>
    <td>4</th>
    <td>5</th>
    <td>6</th>
    <td>7</th>
    <td>8</th>
  </tr>
  <tr>
    <td>x</td>
    <td>8</td>
    <td>7</td>
    <td>6</td>
    <td>5</td>
    <td>4</td>
    <td>3</td>
    <td>2</td>
    <td>9</td>
    <td>8</td>
    <td>7</td>
    <td>6</td>
    <td>5</td>
    <td>4</td>
    <td>3</td>
    <td>2</td>
  </tr>
  <tr>
    <td></td>
    <td>8</td>
    <td>14</td>
    <td>18</td>
    <td>20</td>
    <td>0</td>
    <td>0</td>
    <td>2</td>
    <td>9</td>
    <td>16</td>
    <td>21</td>
    <td>24</td>
    <td>25</td>
    <td>24</td>
    <td>21</td>
    <td>16</td>
  </tr>
</table>

3. Sum the results  
`8 + 14 + 18 + 20 + 0 + 0 + 2 + 9 + 16 + 21 + 24 + 25 + 24 + 21 + 16 = 218`

4. Multiply by `10`  
`218 x 10 = 2180`

5. Get the mod of the multiplication by `11`  
`2180 % 11 = 2`

In this case, the digit would be `2`.

## Calculating the account check digit

Weight: `9, 8, 7, 6, 5, 4, 3, 2`

If the agency, operation or account number length is under 8 digits, fill with 0's on the left (Example: `1234` becomes `00001234`).