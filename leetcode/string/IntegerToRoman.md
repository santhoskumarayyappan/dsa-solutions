14-04-2025
[Question](https://leetcode.com/problems/integer-to-roman/)

```Java
class Solution {
    class SymbolValue {
        int value;
        String symbol;

        SymbolValue(int value, String symbol) {
            this.value = value;
            this.symbol = symbol;
        }
    }
    public String intToRoman(int num) {
        List<SymbolValue> symbolValueList = new ArrayList<>();
        symbolValueList.add(new SymbolValue(1, "I"));
        symbolValueList.add(new SymbolValue(4, "IV"));
        symbolValueList.add(new SymbolValue(5, "V"));
        symbolValueList.add(new SymbolValue(9, "IX"));
        symbolValueList.add(new SymbolValue(10, "X"));
        symbolValueList.add(new SymbolValue(40, "XL"));
        symbolValueList.add(new SymbolValue(50, "L"));
        symbolValueList.add(new SymbolValue(90, "XC"));
        symbolValueList.add(new SymbolValue(100, "C"));
        symbolValueList.add(new SymbolValue(400, "CD"));
        symbolValueList.add(new SymbolValue(500, "D"));
        symbolValueList.add(new SymbolValue(900, "CM"));
        symbolValueList.add(new SymbolValue(1000, "M"));

        StringBuilder sb = new StringBuilder("");
        int index = symbolValueList.size() - 1;
        while (num > 0) {
            while (symbolValueList.get(index).value > num)
                index--;
            sb.append(symbolValueList.get(index).symbol);
            num -= symbolValueList.get(index).value;
        }

        return sb.toString();
    }
}
```
