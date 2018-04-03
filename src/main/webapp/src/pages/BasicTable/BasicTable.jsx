

import React, { Component } from 'react';

import SelectableTable from './components/SelectableTable';

import './BasicTable.scss';

export default class BasicTable extends Component {
  static displayName = 'BasicTable';

  constructor(props) {
    super(props);
    this.state = {};
  }

  render() {
    return (
      <div className="basic-table-page">
        <SelectableTable />
      </div>
    );
  }
}
