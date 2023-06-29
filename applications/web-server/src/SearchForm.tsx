import React from 'react';
import { useForm } from "react-hook-form";
import 'semantic-ui-css/semantic.min.css'
import {Form, Button, Icon} from 'semantic-ui-react';

type FormData = {
  search: string;
};

interface Props {
  onSubmit: (query: String) => void;
}

function SearchForm(props: Props) {
  const { register, handleSubmit, formState: { errors } } = useForm<FormData>();
  const handleSearch = handleSubmit(data =>
      props.onSubmit(data.search)
  );
  const searchOptions = {
    search: { required: "Search is required" },
  };

  return (
      <Form onSubmit={handleSearch}>
        <Form.Field required>
          <input
              placeholder='Add your filter here'
              type="text"
              {...register("search", searchOptions.search)}
          />
        </Form.Field>
        <small className="text-danger">
          {errors?.search && errors.search.message}
        </small>
        <Button color='teal' fluid size='large'>
          <Icon name='search' />
          Search
        </Button>
      </Form>
  );
}

export default SearchForm;