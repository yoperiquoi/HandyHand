import React from 'react';
import { useHistory } from 'react-router-dom';
import { Button, Form, Row, Container } from 'react-bootstrap';
import { useForm } from 'react-hook-form';
import ContentPage from '../../containers/ContentPage';
import { NewScript } from '../../utils/HandyHandAPI/HandyHandAPIType';
import HandyHandAPI from '../../utils/HandyHandAPI/HandyHandAPI';
import routes from '../../constants/routes.json';

interface FormElements {
  file: FileList;
  description: string;
}

export default function AddScriptFeature() {
  const { register, handleSubmit, errors } = useForm<FormElements>();
  const history = useHistory();

  const onSubmit = (data: FormElements) => {
    const file: File | null = data.file.item(0);
    if (file == null) {
      throw new Error('No file found');
    }

    file.text().then((val) => {
      const returnData: NewScript = {
        file: btoa(val),
        description: data.description,
        execType: file.type,
        args: [],
      };
      new HandyHandAPI()
        .addNewScript(returnData)
        .then((r) => history.push(routes.MY_SCRIPT))
        .catch((err) => console.log(err));
    });
  };

  return (
    <ContentPage childrenName="Add Script">
      <Container>
        <Row>
          <Form onSubmit={handleSubmit(onSubmit)}>
            <Form.Group>
              <Form.File
                className="position-relative"
                required
                label="Choisissez un script"
                feedbackTooltip
                id="file"
                name="file"
                ref={register({ required: true })}
              />
              {errors.file && errors.file.type === 'required' && (
                <div className="error">The file is mandatory</div>
              )}
            </Form.Group>

            <Form.Group controlId="formGridAddress1">
              <Form.Label>Description</Form.Label>
              <Form.Control
                as="textarea"
                rows={3}
                id="description"
                name="description"
                ref={register}
              />
            </Form.Group>
            <Button type="submit" variant="primary">
              SUBMIT
            </Button>
          </Form>
        </Row>
      </Container>
    </ContentPage>
  );
}
