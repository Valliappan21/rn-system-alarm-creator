# rn-system-alarm-creator
add alarm to system alarm
## Installation

```sh
npm install https://github.com/Valliappan21/rn-system-alarm-creator
```

## Usage

```js
import { setAlarm } from "rn-system-alarm-creator";
//days
// 1 -> Sunday
// 2 -> Monday
// 3 -> Tuesday
// 4 -> Wednesday
// 5 -> Thursday
// 6 -> Friday
// 7 -> Saturday
let data = {
    hours: 22, 
    mins: 10,
    name: 'my alarm',
    days:[1,2,3,4,5,6,7]
 }
// ...

setAlarm(data);
```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT

---

Made with [create-react-native-library](https://github.com/callstack/react-native-builder-bob)
