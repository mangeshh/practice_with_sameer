html javascript onclick and same in react and angular with example
Certainly! Let's start with an example of an HTML and JavaScript code that uses the onclick event. Then, we'll show how the same functionality can be achieved in React and Angular.

HTML and JavaScript (onclick event):

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Click Example</title>
</head>
<body>
  <button onclick="handleClick()">Click Me</button>

  <script>
    function handleClick() {
      alert("Button clicked!");
    }
  </script>
</body>
</html>
```

In the above code, we have an HTML button with the onclick attribute set to the handleClick() JavaScript function. When the button is clicked, the handleClick() function is invoked, displaying an alert message.
Now let's see how we can achieve the same functionality in React and Angular.

React (onClick event):

Create a new React project using Create React App or your preferred method.
Open the generated `App.js` file and replace its contents with the following code:

```javascript
import React from 'react';

function App() {
  const handleClick = () => {
    alert("Button clicked!");
  };

  return (
    <div>
      <button onClick={handleClick}>Click Me</button>
    </div>
  );
}

export default App;
```

In the above code, we define a functional component called App. Inside this component, we have a button with an onClick event handler that calls the handleClick function when clicked. The function displays an alert message.

Angular (click event):

Set up a new Angular project using the Angular CLI.
Open the generated app.component.html file and replace its contents with the following code:

```
<div>
  <button (click)="handleClick()">Click Me</button>
</div>
```

Open the `app.component.ts` file and replace its contents with the following code:

```javascript
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  handleClick(): void {
    alert("Button clicked!");
  }
}
```

In the Angular code, we define the handleClick() method in the AppComponent class. The button in the HTML template uses the (click) event binding to call the handleClick() method when clicked, displaying an alert message.
In both React and Angular, we use the onClick (React) or (click) (Angular) event bindings to handle button clicks. The event handlers invoke the corresponding functions, resulting in an alert message being displayed when the button is clicked.
Feel free to create new React and Angular projects, replace the necessary files with the provided code, and run the applications to see the button-click functionality in action.

--------------------------------------------------------------------

Sure, let's take the `mousemove` event as an example.

**HTML with JavaScript:**

HTML:
```html
<div id="myDiv">Move mouse over me</div>
```

JavaScript:
```javascript
document.getElementById('myDiv').addEventListener('mousemove', function(event) {
  console.log(`Mouse position: ${event.clientX}, ${event.clientY}`);
});
```

**React:**

React:

```jsx
import React from 'react';

class MyDiv extends React.Component {
  handleMouseMove = (event) => {
    console.log(`Mouse position: ${event.clientX}, ${event.clientY}`);
  }

  render() {
    return (
      <div onMouseMove={this.handleMouseMove}>Move mouse over me</div>
    );
  }
}

export default MyDiv;
```

**Angular:**

HTML:
```html
<div (mousemove)="handleMouseMove($event)">Move mouse over me</div>
```

TypeScript:
```typescript
import { Component } from '@angular/core';

@Component({
  selector: 'my-app',
  templateUrl: './app.component.html',
  styleUrls: [ './app.component.css' ]
})
export class AppComponent  {
  handleMouseMove(event: MouseEvent) {
    console.log(`Mouse position: ${event.clientX}, ${event.clientY}`);
  }
}
```

In these examples, when you move the mouse over the specified element, the position of the mouse (clientX and clientY) will be logged to the console.


--------------------------------------------------------

Sure, let's explore some other common events:

**HTML with JavaScript:**

*onload event:*

HTML:
```html
<body onload="loadFunction()">
```

JavaScript:
```javascript
function loadFunction() {
  alert('Page is loaded');
}
```

*onkeydown event:*

HTML:
```html
<input type="text" id="myInput">
```

JavaScript:
```javascript
document.getElementById('myInput').onkeydown = function(event) {
  console.log('Key down event: ' + event.key);
};
```

**React:**

*componentDidMount event (similar to onload):*

```jsx
import React from 'react';

class MyComponent extends React.Component {
  componentDidMount() {
    alert('Component has mounted');
  }

  render() {
    return (
      <div>My Component</div>
    );
  }
}

export default MyComponent;
```

*onKeyDown event:*

```jsx
import React from 'react';

class MyInput extends React.Component {
  handleKeyDown = (event) => {
    console.log('Key down event: ' + event.key);
  }

  render() {
    return (
      <input type="text" onKeyDown={this.handleKeyDown} />
    );
  }
}

export default MyInput;
```

**Angular:**

*ngOnInit (similar to onload):*

TypeScript:
```typescript
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'my-app',
  templateUrl: './app.component.html',
  styleUrls: [ './app.component.css' ]
})
export class AppComponent implements OnInit {
  ngOnInit() {
    alert('Component has been initialized');
  }
}
```

*keydown event:*

HTML:
```html
<input type="text" (keydown)="handleKeyDown($event)">
```

TypeScript:
```typescript
import { Component } from '@angular/core';

@Component({
  selector: 'my-app',
  templateUrl: './app.component.html',
  styleUrls: [ './app.component.css' ]
})
export class AppComponent {
  handleKeyDown(event: KeyboardEvent) {
    console.log('Key down event: ' + event.key);
  }
}
```

Here we've looked at some more event types, notably the page/component load events (onload in HTML/JS, componentDidMount in React, and ngOnInit in Angular) and the keydown event in an input field.

------------------------------------------------

Event propagation refers to the order in which event handlers are called when one element is nested inside a second element, and both elements have registered a listener for the same event (a click, for example).

The order is:

1. **Capture phase**: The event starts at the top (the outermost element) and works its way down to the target element (innermost element).
2. **Target phase**: The event reaches the target element.
3. **Bubbling phase**: The event bubbles up from the target element to the top.

This is default behavior and happens automatically.

But how can we manually stop event propagation?

**JavaScript:**

We can use `stopPropagation` method:

```javascript
document.getElementById('outer').addEventListener('click', function(e) {
  alert('Outer div clicked');
});

document.getElementById('inner').addEventListener('click', function(e) {
  e.stopPropagation();
  alert('Inner div clicked');
});
```

In this example, if you click the inner div, you will only see "Inner div clicked" and not "Outer div clicked".

**React:**

In React, you can also use `stopPropagation`:

```jsx
import React from 'react';

function App() {
  return (
    <div onClick={() => alert('Outer div clicked')}>
      <div onClick={(e) => {
        e.stopPropagation();
        alert('Inner div clicked');
      }}>
        Inner
      </div>
    </div>
  );
}

export default App;
```

In this React example, if you click the inner div, you will only see "Inner div clicked" and not "Outer div clicked".

**Angular:**

In Angular, you can prevent event propagation by calling `$event.stopPropagation()` in your event handler:

```html
<div (click)="outerDivClicked()">
  <div (click)="$event.stopPropagation(); innerDivClicked()">
    Inner
  </div>
</div>
```

```typescript
import { Component } from '@angular/core';

@Component({
  selector: 'my-app',
  templateUrl: './app.component.html',
  styleUrls: [ './app.component.css' ]
})
export class AppComponent  {
  outerDivClicked() {
    alert('Outer div clicked');
  }

  innerDivClicked() {
    alert('Inner div clicked');
  }
}
```

In this Angular example, if you click the inner div, you will only see "Inner div clicked" and not "Outer div clicked".

------------------------------
