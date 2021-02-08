import { Col, Row } from 'react-bootstrap';
import React from 'react';
import { ScriptCard } from '../HandyHandAPI/HandyHandAPIType';
import CardScript from '../../components/CardScript';
import LineScript from '../../components/LineScript';

export function propsNameToDisplayName(name: string): string {
  return name.split('/').reverse()[0].split('.')[0];
}

export function allCards(items: ScriptCard[]): JSX.Element {
  const elements: JSX.Element[] = [];

  let i: number = items.length;
  while (i > 0) {
    const subElements: JSX.Element[] = [];
    const iter: number = i < 3 ? i : 3;

    for (let j = 0; j < iter; j++) {
      subElements.push(
        <Col>
          <CardScript
            title={items[(i - items.length) * -1 + j].file}
            description={items[(i - items.length) * -1 + j].description}
          />
        </Col>
      );
    }
    if (iter == 2) {
      subElements.push(<Col />);
    }

    elements.push(<Row>{subElements}</Row>);
    i -= 3;
  }

  return <div>{elements}</div>;
}

export function allList(items: ScriptCard[]): JSX.Element {
  const elements: JSX.Element[] = [];
  for (let i = 0; i < items.length; i++) {
    elements.push(
      <Row>
        <Col>
          <LineScript title={propsNameToDisplayName(items[i].file)} description={items[i].description} />
        </Col>
      </Row>
    );
  }

  return <div>{elements}</div>;
}

