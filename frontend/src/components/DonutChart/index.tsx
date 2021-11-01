import Chart from 'react-apexcharts';

function DonutChart() {

  const mockData = {
    series: [477138, 499928, 444867, 220426, 473088],
    labels: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
  }

  const options = {
    legend: {
      show: true
    }
  }

  return (

    // Temos que passar os argumentos do Chart/grafico
    <Chart

      // Quando usamos o ... estamos falando para ele pegar tudo que estiver dentro dele.
      // O xaxis é o eixo X e estamos pegando a função mockData. 
      options={{ ...options, labels: mockData.labels }}

      // Passando os valores.
      series={mockData.series}

      // Tipo
      type="donut"

      // Tamanho
      height="240"

    />

  );
}

export default DonutChart;
