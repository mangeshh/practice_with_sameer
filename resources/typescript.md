#### basic types
```javascript
let name: string = 'John';
let age: number = 30;
let isStudent: boolean = false;

console.log(name, age, isStudent);
```

#### Interfaces:
```javascript
interface User {
  name: string;
  age: number;
  email?: string;
}

const user: User = {
  name: 'John',
  age: 30,
  email: 'john@example.com',
};

console.log(user);

```
#### Classes:
```javascript
class Person {
  name: string;
  age: number;

  constructor(name: string, age: number) {
    this.name = name;
    this.age = age;
  }

  greet() {
    console.log(`Hello, my name is ${this.name} and I am ${this.age} years old.`);
  }
}

const person = new Person('John', 30);
person.greet();


```

#### modules:

```javascript

//File: math.ts

export function sum(a: number, b: number): number {
  return a + b;
}

export function multiply(a: number, b: number): number {
  return a * b;
}

// File: app.ts

import { sum, multiply } from './math';

console.log(sum(5, 3)); // Output: 8
console.log(multiply(2, 4)); // Output: 8


```

#### Generics
```javascript
function getFirstElement<T>(arr: T[]): T {
  return arr[0];
}

const numbers = [1, 2, 3];
const firstNumber = getFirstElement(numbers);
console.log(firstNumber); // Output: 1

const names = ['John', 'Jane', 'Jake'];
const firstName = getFirstElement(names);
console.log(firstName); // Output: 'John'

```

#### Decorators:
```javascript
function logMethod(target: any, key: string, descriptor: PropertyDescriptor) {
  const originalMethod = descriptor.value;
  descriptor.value = function (...args: any[]) {
    console.log(`Method ${key} called with arguments: ${args}`);
    return originalMethod.apply(this, args);
  };
  return descriptor;
}

class Calculator {
  @logMethod
  add(a: number, b: number) {
    return a + b;
  }
}

const calc = new Calculator();
console.log(calc.add(5, 3)); // Output: Method add called with arguments: 5,3 | Result: 8

```

#### Asynchronous Programming:
```javascript
function fetchData(): Promise<string> {
  return new Promise((resolve) => {
    setTimeout(() => {
      resolve('Data fetched successfully');
    }, 2000);
  });
}

async function getData() {
  const data = await fetchData();
  console.log(data);
}

getData();
```