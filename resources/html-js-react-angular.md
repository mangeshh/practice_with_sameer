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