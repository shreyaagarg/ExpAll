import React, { Component } from 'react';
import { HashRouter as Router, Route, NavLink } from 'react-router-dom';
import './App.css';
import './HomePage.js';
import hey from './pages/hey.js';

class App extends Component {
    search(){
    }
    feelinglucky()
    {

    }
    render() {
        return (
            <Router>
            <div>
                <title> search</title>
                <center>
                    <h1 style={{fontSize: 49, marginTop: 200}}><span style={{color: 'blue'}}>E</span><span style={{color: 'red'}}>x</span><span style={{color: 'yellow'}}>p</span><span style={{color: 'blue'}}>A</span><span style={{color: 'green'}}>l</span><span style={{color: 'red'}}>l</span></h1>
                    <input name="searchengine" size={70} type="search" /><br />
                    <br />
                    <button onClick={this.search()}>Search</button>

                    <button onClick={this.feelinglucky()}>feeling lucky</button>
                </center>
                <a href="">signup</a>
                <NavLink to="/call">Login</NavLink>;
                <Route path="/call" component={hey}>
                </Route>


            </div>
            </Router>
        );
    }
}

export default App;
