import React, { Component } from 'react';

class HomePage extends Component {
    render() {
        return (
            <div>
                <title> search</title>
                <center>
                    <h1 style={{fontSize: 49, marginTop: 200}}><span style={{color: 'blue'}}>E</span><span style={{color: 'red'}}>x</span><span style={{color: 'yellow'}}>p</span><span style={{color: 'blue'}}>A</span><span style={{color: 'green'}}>l</span><span style={{color: 'red'}}>l</span></h1>
                    <input name="searchengine" size={70} type="search" /><br />
                    <br />
                    <input defaultValue="ExpAll search" type="search" />&nbsp; <input defaultValue="feeling lucky" type="search" />
                </center>
            </div>
        );
    }
}


export default HomePage;