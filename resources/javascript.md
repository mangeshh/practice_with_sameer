## javascript notes
#### 1. Variables and Data Types:

```
let name = 'John';
const age = 30;
var isStudent = true;
const numbers = [1, 2, 3, 4, 5];
const person = { name: 'John', age: 30 };
```

#### 2. Operators:
```
let sum = 5 + 3;
let difference = 10 - 5;
let product = 2 * 4;
let quotient = 12 / 3;

let isEqual = 5 === 5;
let isGreaterThan = 10 > 5;
let logicalAnd = true && false;

let logicalOr = true || false;
let logicalNot = !true;
```

#### 3. Control Flow:

```
let hour = 12;
if (hour < 12) {
  console.log('Good morning!');
} else if (hour < 18) {
  console.log('Good afternoon!');
} else {
  console.log('Good evening!');
}

for (let i = 0; i < numbers.length; i++) {
  console.log(numbers[i]);
}

let i = 0;
while (i < numbers.length) {
  console.log(numbers[i]);
  i++;
}
```


#### 4. Function declaration

``` javascript
function greet(name) {
   console.log(`Hello, ${name}!`);
}

greet('John'); // Output: Hello, John!

```

```javascript
const sum = function (a, b) {
  return a + b;
};

console.log(sum(5, 3)); // Output: 8

```

######    4.1 Arrow Functions:

```
const sum = (a, b) => a + b;

// Arrow function with implicit return
const square = (num) => num * num;

// Arrow function with a single parameter
const greet = name => `Hello, ${name}!`;

console.log(sum(5, 3)); // Output: 8
console.log(square(4)); // Output: 16
console.log(greet('John')); // Output: Hello, John!

```

######    4.2 Destructuring Assignment:
```
// Destructuring assignment for arrays
const numbers = [1, 2, 3, 4, 5];
const [first, second, , fourth] = numbers;

console.log(first); // Output: 1
console.log(second); // Output: 2
console.log(fourth); // Output: 4

// Destructuring assignment for objects
const person = { name: 'John', age: 30 };
const { name, age } = person;

console.log(name); // Output: John
console.log(age); // Output: 30
```

######    4.3 Spread Syntax:

```// Spread syntax for arrays
const numbers = [1, 2, 3];
const newNumbers = [...numbers, 4, 5];

console.log(newNumbers); // Output: [1, 2, 3, 4, 5]

// Spread syntax for objects
const person = { name: 'John', age: 30 };
const newPerson = { ...person, occupation: 'Developer' };

console.log(newPerson);
// Output: { name: 'John', age: 30, occupation: 'Developer' }
```

###### 4.4 Higher-Order Functions:

```
multiplyBy = multiplyBy(factor) {
  return function (number) {
    return number * factor;
  };
}

const multiplyByTwo = multiplyBy(2);
console.log(multiplyByTwo(5)); // Output: 10
console.log(multiplyByTwo(10)); // Output: 20
```

###### 4.5 Rest Parameters:

```function sum(...numbers) {
  let total = 0;
  for (let number of numbers) {
    total += number;
  }
  return total;
}

console.log(sum(1, 2, 3, 4, 5)); // Output: 15
console.log(sum(10, 20, 30)); // Output: 60
```

###### 4.6 Callback Functions:

```function fetchData(callback) {
  setTimeout(() => {
    const data = 'Fetched data';
    callback(data);
  }, 2000);
}

function processData(data) {
  console.log(`Processing data: ${data}`);
}

fetchData(processData); // Output: Processing data: Fetched data
```

###### 4.7 recursive function:

```function countdown(num) {
  if (num === 0) {
    console.log('Countdown complete!');
  } else {
    console.log(num);
    countdown(num - 1);
  }
}

countdown(5);
// Output:
// 5
// 4
// 3
// 2
// 1
// Countdown complete!
```

###### 4.8 Immediately Invoked Function Expressions (IIFE):

```
(function () {
  const message = 'Hello from IIFE';
  console.log(message);
})();

// Output: Hello from IIFE
```

###### 4.9 Function Methods:

```const person = {
  name: 'John',
  age: 30,
  greet: function () {
    console.log(`Hello, my name is ${this.name} and I am ${this.age} years old.`);
  },
};

person.greet(); // Output: Hello, my name is John and I am 30 years old.
```


#### 5. Arrays and Objects
```
const numbers = [1, 2, 3, 4, 5];
console.log(numbers.length); // Output: 5

const person = { name: 'John', age: 30 };
console.log(person.name); // Output: John

```

###### 5.1 Iterating through an Array:
```
const numbers = [1, 2, 3, 4, 5];

// Looping through an array
for (let i = 0; i < numbers.length; i++) {
  console.log(numbers[i]);
}

// Using forEach() method
numbers.forEach((number) => {
  console.log(number);
});

// Using for...of loop
for (let number of numbers) {
  console.log(number);
}
```
###### 5.2 Array Methods:
```
const numbers = [1, 2, 3, 4, 5];

// Adding elements to the end of an array
numbers.push(6);

// Removing elements from the end of an array
numbers.pop();

// Adding elements to the beginning of an array
numbers.unshift(0);

// Removing elements from the beginning of an array
numbers.shift();

// Finding the index of an element
const index = numbers.indexOf(3);

// Slicing an array
const slicedArray = numbers.slice(1, 4);

console.log(numbers); // Output: [1, 2, 3, 4, 5]
console.log(index); // Output: 2
console.log(slicedArray); // Output: [2, 3, 4]

```

###### 5.3 Object Properties:
```
const person = {
  name: 'John',
  age: 30,
  occupation: 'Developer',
};

// Accessing object properties using dot notation
console.log(person.name); // Output: John
console.log(person.age); // Output: 30

// Accessing object properties using bracket notation
console.log(person['occupation']); // Output: Developer

// Dynamically adding or modifying object properties
person.location = 'New York';
person.age = 31;

console.log(person); // Output: { name: 'John', age: 31, occupation: 'Developer', location: 'New York' }

```

###### 5.4 Object Methods:
```
const calculator = {
  add: function (a, b) {
    return a + b;
  },
  multiply: function (a, b) {
    return a * b;
  },
};

console.log(calculator.add(5, 3)); // Output: 8
console.log(calculator.multiply(2, 4)); // Output: 8

```

######  5.5 Object Iteration:
```
const person = {
  name: 'John',
  age: 30,
  occupation: 'Developer',
};

// Looping through object properties using for...in loop
for (let key in person) {
  console.log(key + ': ' + person[key]);
}

// Getting an array of object keys
const keys = Object.keys(person);
console.log(keys); // Output: ['name', 'age', 'occupation']

// Getting an array of object values
const values = Object.values(person);
console.log(values); // Output: ['John', 30, 'Developer']

```

#### 6. DOM Manipulation:
```
// Get an element by ID and modify its content
const heading = document.getElementById('my-heading');
heading.textContent = 'Hello, JavaScript!';
```

###### 6.1 Accessing Elements:

```
// Access an element by its ID
const heading = document.getElementById('my-heading');
console.log(heading.textContent); // Output: Content of the heading element

// Access elements by their class name
const paragraphs = document.getElementsByClassName('my-paragraph');
console.log(paragraphs.length); // Output: Number of paragraphs with the given class

// Access elements by their tag name
const listItems = document.getElementsByTagName('li');
console.log(listItems.length); // Output: Number of list items on the page
```

###### 6.2 Modifying Element Content:

```
// Change the text content of an element
const heading = document.getElementById('my-heading');
heading.textContent = 'New Heading';

// Change the HTML content of an element
const paragraph = document.getElementById('my-paragraph');
paragraph.innerHTML = '<em>New content</em>';

```

###### 6.3 Modifying Element Attributes:

```
// Change the value of an input field
const input = document.getElementById('my-input');
input.value = 'New value';

// Change the source attribute of an image
const image = document.getElementById('my-image');
image.src = 'new-image.jpg';
```

###### 6.4 Adding and Removing Classes:

```
// Add a class to an element
const element = document.getElementById('my-element');
element.classList.add('new-class');

// Remove a class from an element
element.classList.remove('old-class');
```

###### 6.5 Creating New Elements:

```
// Create a new paragraph element
const newParagraph = document.createElement('p');
newParagraph.textContent = 'New paragraph content';

// Append the new element to an existing element
const container = document.getElementById('container');
container.appendChild(newParagraph);
```

###### 6.6 Event Handling:
```
// Add an event listener to a button
const button = document.getElementById('my-button');
button.addEventListener('click', function () {
  console.log('Button clicked!');
});

// Remove an event listener from an element
function handleClick() {
  console.log('Button clicked!');
}

button.addEventListener('click', handleClick);
button.removeEventListener('click', handleClick);
```

###### 6.7 Modifying CSS Styles:
```
// Change the style properties of an element
const element = document.getElementById('my-element');
element.style.color = 'red';
element.style.fontSize = '20px';

```

###### 6.8 Traversing the DOM:
```
// Traverse the DOM and access child elements
const parent = document.getElementById('parent-element');
const children = parent.children;
console.log(children.length); 
// Output: Number of child elements

// Traverse the DOM and access parent elements
const child = document.getElementById('child-element');
const parent = child.parentElement;
console.log(parent.id); 
// Output: ID of the parent element
```


#### 7. classes:

```
const person = {
  name: 'John',
  age: 30,
  greet: function () {
    console.log(`Hello, my name is ${this.name} and I am ${this.age} years old.`);
  },
};

person.greet(); // Output: Hello, my name is John and I am 30 years old.
```


###### 7.1 Inheritance

``` 
class Square extends Rectangle {
  constructor(side) {
    super(side, side);
  }
}

const square = new Square(4);
console.log(square.getArea()); // Output: 16
```

###### 7.2 Getter and setter:
```
class Circle {
  constructor(radius) {
    this.radius = radius;
  }

  get area() {
    return Math.PI * this.radius ** 2;
  }

  set diameter(diameter) {
    this.radius = diameter / 2;
  }
}

const circle = new Circle(5);
console.log(circle.area); // Output: 78.53981633974483

circle.diameter = 10;
console.log(circle.radius); // Output: 5
```

###### 7.3 Static Methods:

```
class MathUtils {
  static add(a, b) {
    return a + b;
  }

  static multiply(a, b) {
    return a * b;
  }
}

console.log(MathUtils.add(5, 3)); // Output: 8
console.log(MathUtils.multiply(2, 4)); // Output: 8
```

###### 7.4 Class Expressions:

```class Jumpable {
  jump() {
    console.log('Jumping!');
  }
}

class Flyable {
  fly() {
    console.log('Flying!');
  }
}

class Superhero {
  constructor(name) {
    this.name = name;
  }
}

Object.assign(Superhero.prototype, Jumpable.prototype, Flyable.prototype);

const superman = new Superhero('Superman');
superman.jump(); // Output: Jumping!
superman.fly(); // Output: Flying!
```

###### 7.5 Mixins (Class Composition):

```
class Jumpable {
  jump() {
    console.log('Jumping!');
  }
}

class Flyable {
  fly() {
    console.log('Flying!');
  }
}

class Superhero {
  constructor(name) {
    this.name = name;
  }
}

Object.assign(Superhero.prototype, Jumpable.prototype, Flyable.prototype);

const superman = new Superhero('Superman');
superman.jump(); // Output: Jumping!
superman.fly(); // Output: Flying!
```

##### 8 Events and Event Handling:

```
// Event handling - adding event listener.
const button = document.getElementById('my-button');
button.addEventListener('click', function () {
  console.log('Button clicked!');
});
```

###### 8.1 Event Propagation (Bubbling and Capturing):
```
// Event bubbling (default behavior)
const parentElement = document.getElementById('parent');
const childElement = document.getElementById('child');

parentElement.addEventListener('click', function () {
  console.log('Parent clicked!');
});

childElement.addEventListener('click', function () {
  console.log('Child clicked!');
});

// Event capturing
parentElement.addEventListener(
  'click',
  function () {
    console.log('Parent clicked!');
  },
  true
);

childElement.addEventListener(
  'click',
  function () {
    console.log('Child clicked!');
  },
  true
);


```
###### 8.2 Removing Event Listeners:
```
// Remove an event listener from a button
const button = document.getElementById('my-button');

function handleClick() {
  console.log('Button clicked!');
}

button.addEventListener('click', handleClick);

// ...later in the code

button.removeEventListener('click', handleClick);

```

###### 8.3 Event Delegation:
```
// Event delegation using event.target
const parentElement = document.getElementById('parent');

parentElement.addEventListener('click', function (event) {
  if (event.target.tagName === 'LI') {
    console.log('List item clicked:', event.target.textContent);
  }
});

```

###### 8.4 Event Object:
```
// Accessing event properties
const button = document.getElementById('my-button');

button.addEventListener('click', function (event) {
  console.log('Button clicked!');
  console.log('Event type:', event.type);
  console.log('Event target:', event.target);
  console.log('Mouse coordinates:', event.clientX, event.clientY);
});

```

###### 8.5 Event Prevent Default:
```
// Prevent default behavior of a link click
const link = document.getElementById('my-link');

link.addEventListener('click', function (event) {
  event.preventDefault();
  console.log('Link clicked, but default behavior prevented.');
});

```

###### 8.6 Mouse event:
```
// Mouse click event
const button = document.getElementById('my-button');
button.addEventListener('click', function () {
  console.log('Button clicked!');
});

// Mouse over event
const element = document.getElementById('my-element');
element.addEventListener('mouseover', function () {
  console.log('Mouse over the element!');
});

// Mouse move event
document.addEventListener('mousemove', function (event) {
  console.log('Mouse coordinates:', event.clientX, event.clientY);
});

```

###### 8.7 Keyboard Events:
```
// Keydown event
document.addEventListener('keydown', function (event) {
  console.log('Key pressed:', event.key);
});

// Keypress event
document.addEventListener('keypress', function (event) {
  console.log('Key pressed:', event.key);
});

// Keyup event
document.addEventListener('keyup', function (event) {
  console.log('Key released:', event.key);
});

```

###### 8.8 Form Events:
```
// Form submission event
const form = document.getElementById('my-form');
form.addEventListener('submit', function (event) {
  event.preventDefault();
  console.log('Form submitted!');
});

// Input field change event
const input = document.getElementById('my-input');
input.addEventListener('input', function () {
  console.log('Input field value:', input.value);
});

```

###### 8.9 Event Delegation:
```
// Event delegation using event.target
const parentElement = document.getElementById('parent');

parentElement.addEventListener('click', function (event) {
  if (event.target.tagName === 'LI') {
    console.log('List item clicked:', event.target.textContent);
  }
});

```

###### 8.10 Custom Events:
```
// Custom event creation and handling
const customEvent = new CustomEvent('my-event', { detail: { message: 'Custom event triggered!' } });

document.addEventListener('my-event', function (event) {
  console.log('Custom event received:', event.detail.message);
});

document.dispatchEvent(customEvent); // Dispatch the custom event

```

##### 9 Error Handling:

###### 9.1 Try-catch:
```
try {
  // Code that may throw an error
  throw new Error('Something went wrong');
} catch (error) {
  console.log(error.message); // Output: Something went wrong
}


```

###### 9.2 Custom Error:
```
class CustomError extends Error {
  constructor(message) {
    super(message);
    this.name = 'CustomError';
  }
}

try {
  throw new CustomError('This is a custom error');
} catch (error) {
  console.log(error.name); // Output: CustomError
  console.log(error.message); // Output: This is a custom error
}

```

###### 9.3 Error Propagation:
```
function validateNumber(num) {
  if (typeof num !== 'number') {
    throw new TypeError('Invalid number');
  }
}

function doubleNumber(num) {
  try {
    validateNumber(num);
    return num * 2;
  } catch (error) {
    console.log(error.message);
    // Propagate the error to the calling function
    throw error;
  }
}

try {
  const result = doubleNumber('not a number');
  console.log(result);
} catch (error) {
  console.log('Error occurred:', error.message);
}


```

###### 9.4 Finally Block:
```
function performTask() {
  try {
    // Code that may throw an error
    throw new Error('Error occurred');
  } catch (error) {
    console.log(error.message);
  } finally {
    console.log('Finally block executed');
  }
}

performTask();
// Output:
// Error occurred
// Finally block executed


```

###### 9.5 Handling Asynchronous Errors:

```
function fetchData() {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      reject(new Error('Failed to fetch data'));
    }, 2000);
  });
}

fetchData()
  .then(data => {
    console.log(data);
  })
  .catch(error => {
    console.log('Error:', error.message);
  });
```



##### 10 Modules and Packages: 
//TODO


##### 11 ES6+ Features:
//TODO


##### 12 Asynchronous JavaScript:

###### 12.1 Async Function with Await:

```
function resolveAfterDelay(delay) {
  return new Promise(resolve => {
    setTimeout(() => {
      resolve('Resolved after ' + delay + ' milliseconds');
    }, delay);
  });
}

async function asyncFunction() {
  console.log('Start');
  
  const result1 = await resolveAfterDelay(2000);
  console.log(result1); // Output: Resolved after 2000 milliseconds
  
  const result2 = await resolveAfterDelay(1000);
  console.log(result2); // Output: Resolved after 1000 milliseconds
  
  console.log('End');
}

asyncFunction();

```


###### 12.2 Promise Chaining:
```
function fetchUserData() {
  return new Promise(resolve => {
    setTimeout(() => {
      resolve({ name: 'John', age: 30 });
    }, 2000);
  });
}

function fetchUserPosts(userId) {
  return new Promise(resolve => {
    setTimeout(() => {
      resolve(['Post 1', 'Post 2', 'Post 3']);
    }, 1500);
  });
}

function fetchPostComments(postId) {
  return new Promise(resolve => {
    setTimeout(() => {
      resolve(['Comment 1', 'Comment 2']);
    }, 1000);
  });
}

fetchUserData()
  .then(user => {
    console.log('User:', user);
    return fetchUserPosts(user.id);
  })
  .then(posts => {
    console.log('Posts:', posts);
    return fetchPostComments(posts[0].id);
  })
  .then(comments => {
    console.log('Comments:', comments);
  })
  .catch(error => {
    console.log('Error:', error);
  });

```

###### 12.3 Handling Async Operations with Async/Await and Try/Catch:
```
function fetchData() {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      const randomNumber = Math.random();
      if (randomNumber < 0.5) {
        resolve('Data fetched successfully');
      } else {
        reject('Error fetching data');
      }
    }, 2000);
  });
}

async function performTask() {
  try {
    const data = await fetchData();
    console.log(data); // Output: Data fetched successfully
  } catch (error) {
    console.log(error); // Output: Error fetching data
  }
}

performTask();

```

###### 12.4 Using Promise.all to Await Multiple Promises:
```
function fetchUserData() {
  return new Promise(resolve => {
    setTimeout(() => {
      resolve({ name: 'John', age: 30 });
    }, 2000);
  });
}

function fetchUserPosts() {
  return new Promise(resolve => {
    setTimeout(() => {
      resolve(['Post 1', 'Post 2', 'Post 3']);
    }, 1500);
  });
}

function fetchPostComments() {
  return new Promise(resolve => {
    setTimeout(() => {
      resolve(['Comment 1', 'Comment 2']);
    }, 1000);
  });
}

async function fetchAllData() {
  const [user, posts, comments] = await Promise.all([
    fetchUserData(),
    fetchUserPosts(),
    fetchPostComments()
  ]);

  console.log('User:', user);
  console.log('Posts:', posts);
  console.log('Comments:', comments);
}

fetchAllData();

```

###### 12.5 Promises:
```
function fetchData() {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      const data = 'Fetched data';
      resolve(data);
    }, 2000);
  });
}

fetchData()
  .then(data => {
    console.log(data);
  })
  .catch(error => {
    console.log('Error:', error);
  });

```
###### 12.6 Async/Await:

```function resolveAfterDelay(delay) {
  return new Promise(resolve => {
    setTimeout(() => {
      resolve('Resolved after ' + delay + ' milliseconds');
    }, delay);
  });
}

async function asyncFunction() {
  console.log('Start');
  
  const result1 = await resolveAfterDelay(2000);
  console.log(result1); // Output: Resolved after 2000 milliseconds
  
  const result2 = await resolveAfterDelay(1000);
  console.log(result2); // Output: Resolved after 1000 milliseconds
  
  console.log('End');
}

asyncFunction();



```



