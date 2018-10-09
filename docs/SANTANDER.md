# Santander

Bank code: `033`

## Calculating the account check digit

Weight: `9, 7, 3, 1, 9, 7, 1, 3, 1, 9, 7, 3`

1. Concatenate the agency and account numbers
2. Multiply each number by the correct weight
3. When multiplying, keep only the last digit of the result
4. Sum the results
5. Get the mod of the sum by `10`
6. Subtract the mod by `10`
7. If the result is `10`, then the check digit is `0`. Otherwise, the check digit is the result.

Example:

Agency number: `1234`  
Account number: `12345678`

1. Concatenate the agency and account numbers  
`123412345678`

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
    <td>6</th>
    <td>7</th>
    <td>8</th>
  </tr>
  <tr>
    <td>x</td>
    <td>9</td>
    <td>7</td>
    <td>3</td>
    <td>1</td>
    <td>9</td>
    <td>7</td>
    <td>1</td>
    <td>3</td>
    <td>1</td>
    <td>9</td>
    <td>7</td>
    <td>3</td>
  </tr>
  <tr>
    <td></td>
    <td>9</td>
    <td>14</td>
    <td>9</td>
    <td>4</td>
    <td>9</td>
    <td>14</td>
    <td>3</td>
    <td>12</td>
    <td>5</td>
    <td>54</td>
    <td>49</td>
    <td>24</td>
  </tr>
</table>

3. When multiplying, keep only the last digit of the result

<table>
  <tr>
    <td>9</th>
    <td>14</th>
    <td>9</th>
    <td>4</th>
    <td>9</th>
    <td>14</th>
    <td>3</th>
    <td>12</th>
    <td>5</th>
    <td>54</th>
    <td>49</th>
    <td>24</th>
  </tr>
  <tr>
    <td>9</td>
    <td>4</td>
    <td>9</td>
    <td>4</td>
    <td>9</td>
    <td>4</td>
    <td>3</td>
    <td>2</td>
    <td>5</td>
    <td>4</td>
    <td>9</td>
    <td>4</td>
  </tr>
</table>

4. Sum the results  
`9 + 4 + 9 + 4 + 9 + 4 + 3 + 2 + 5 + 4 + 9 + 4 = 66`

5. Get the mod of the sum by `10`  
`66 % 10 = 6`

6. Subtract the mod by `10`  
`10 - 6 = 4`

7. If the result is `10`, then the check digit is `0`. Otherwise, the check digit is the result.

In this case, the digit would be `4`.
