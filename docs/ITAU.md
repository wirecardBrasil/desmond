# Itaú

Bank code: `341`

## Calculating the account check digit

Weights: `2, 1, 2, 1, 2, 1, 2, 1, 2`

1. Concatenate the agency and account numbers
2. Multiply each number by the correct weight
3. With the result of each multiplication, sum the digits of the result
4. Sum the results
5. Get the mod of the sum by `10`
6. If the result is `10`, then the check digit is `0`.
7. Otherwise, the check digit is the subtraction of the mod by `10`.

Example:

Agency number: `1234`  
Account number: `12345`

1. Concatenate the agency and account numbers  
`123412345`

2. Multiply each number by the correct weight

<table>
  <tr>
    <td></th>
    <td>1</th>
    <td>2</th>
    <td>3</th>
    <td>4</th>
    <td>1</th>
    <td>2</th>
    <td>3</th>
    <td>4</th>
    <td>5</th>
  </tr>
  <tr>
    <td>x</td>
    <td>2</td>
    <td>1</td>
    <td>2</td>
    <td>1</td>
    <td>2</td>
    <td>1</td>
    <td>2</td>
    <td>1</td>
    <td>2</td>
  </tr>
  <tr>
    <td></td>
    <td>2</td>
    <td>2</td>
    <td>6</td>
    <td>4</td>
    <td>2</td>
    <td>2</td>
    <td>6</td>
    <td>4</td>
    <td>10</td>
  </tr>
</table>

3. With the result of each multiplication, sum the digits of the result

<table>
  <tr>
    <td></th>
    <td>2</th>
    <td>2</th>
    <td>6</th>
    <td>4</th>
    <td>2</th>
    <td>2</th>
    <td>6</th>
    <td>4</th>
    <td>10</th>
  </tr>
  <tr>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td>1 + 0</td>
  </tr>
  <tr>
    <td></td>
    <td>2</td>
    <td>2</td>
    <td>6</td>
    <td>4</td>
    <td>2</td>
    <td>2</td>
    <td>6</td>
    <td>4</td>
    <td>1</td>
  </tr>
</table>

4. Sum the results  
`2 + 2 + 6 + 4 + 2 + 2 + 6 + 4 + 1 = 29`

5. Get the mod of the sum by `10`  
`29 % 10 = 9`

6. If the remainder is `0`, the check digit is `0`

7. Otherwise, the check digit is the difference of the mod (`10`) and the remainder.  
`10 - 9 = 1`

In this case, the digit would be `1`.